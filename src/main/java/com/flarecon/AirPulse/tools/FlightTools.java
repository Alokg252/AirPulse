package com.flarecon.AirPulse.tools;

import com.flarecon.AirPulse.model.flight.Flight;
import com.flarecon.AirPulse.repository.flight.FlightRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;

@Component
public class FlightTools {

    private final FlightRepository flightRepository;

    public FlightTools(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

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
}