package com.flarecon.AirPulse.tools;

import com.flarecon.AirPulse.model.flight.Flight;
import com.flarecon.AirPulse.model.flight.FlightBooking;
import com.flarecon.AirPulse.repository.flight.FlightRepository;
import com.flarecon.AirPulse.service.flight.FlightBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FlightTools {

    private final FlightRepository flightRepository;
    private final FlightBookingService flightBookingService;

    @Tool(description = "Search flights with optional filters")
    public List<Flight> searchFlights(
            String fromCity,
            String toCity,
            String startDate,
            String endDate,
            Integer passengers,
            Double maxPrice
    ) {

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime start = (startDate == null) ? now : ZonedDateTime.parse(startDate + "T00:00:00Z");
        ZonedDateTime end = (endDate == null) ? now.plusDays(2) : ZonedDateTime.parse(endDate + "T23:59:59Z");

        int pax = (passengers == null) ? 1 : passengers;
        double priceLimit = (maxPrice == null) ? Double.MAX_VALUE : maxPrice;

        return flightRepository.findAll().stream()
                .filter(f -> f.getFromCity().equalsIgnoreCase(fromCity))
                .filter(f -> f.getToCity().equalsIgnoreCase(toCity))
                .filter(f -> !f.getDepartureTime().isBefore(start))
                .filter(f -> !f.getDepartureTime().isAfter(end))
                .filter(f -> f.getAvailableSeats() >= pax)
                .filter(f -> f.getPrice() <= priceLimit)
                .toList();
    }

    @Tool(description = "Search flights with optional arguments just pass '' (empty or space) in the arguments you dont have ")
    public List<Flight> searchFlightsWithOptionalArgs(String fromCity, String toCity, String departureDate, String landingDate) {
        LocalDate parsedDepartureDate = parseOptionalDate(departureDate, "departureDate");
        LocalDate parsedLandingDate = parseOptionalDate(landingDate, "landingDate");

        return flightRepository.findAll().stream()
                .filter(f -> hasNoText(fromCity) || (f.getFromCity() != null && f.getFromCity().equalsIgnoreCase(fromCity.trim())))
                .filter(f -> hasNoText(toCity) || (f.getToCity() != null && f.getToCity().equalsIgnoreCase(toCity.trim())))
                .filter(f -> parsedDepartureDate == null || (f.getDepartureTime() != null && f.getDepartureTime().toLocalDate().isEqual(parsedDepartureDate)))
                .filter(f -> parsedLandingDate == null || (f.getArrivalTime() != null && f.getArrivalTime().toLocalDate().isEqual(parsedLandingDate)))
                .toList();
    }

    private boolean hasNoText(String value) {
        return value == null || value.trim().isEmpty();
    }

    private LocalDate parseOptionalDate(String value, String fieldName) {
        if (hasNoText(value)) {
            return null;
        }

        try {
            return LocalDate.parse(value.trim());
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException(fieldName + " must be in yyyy-MM-dd format", ex);
        }
    }

    @Tool(description = "Book a flight using flight's id")
    public FlightBooking bookFlight(Integer flightId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return flightBookingService.createBooking(flightId.longValue(), username);
    }
}