package com.flarecon.AirPulse.service.flight;

import com.flarecon.AirPulse.model.flight.Flight;
import com.flarecon.AirPulse.model.flight.FlightStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;

@Component
public class FlightGenerator {

    private static final List<String[]> ROUTES = List.of(
            new String[]{"Delhi", "Paris"},
            new String[]{"Delhi", "London"},
            new String[]{"Mumbai", "Dubai"},
            new String[]{"Bangalore", "Singapore"},
            new String[]{"Delhi", "New York"},
            new String[]{"Mumbai", "Doha"}
    );

    private final Random random = new Random();

    public Flight generateFlight(LocalDate date) {

        String[] route = ROUTES.get(random.nextInt(ROUTES.size()));

        int hour = 6 + random.nextInt(16); // 6 AM → 10 PM

        ZonedDateTime departure = date.atTime(hour, 0)
                .atZone(ZoneId.systemDefault());

        ZonedDateTime arrival = departure.plusHours(6 + random.nextInt(6));

        Flight flight = new Flight();
        flight.setFlightNumber("FL" + (100 + random.nextInt(900)));
        flight.setFromCity(route[0]);
        flight.setToCity(route[1]);
        flight.setDepartureTime(departure);
        flight.setArrivalTime(arrival);

        flight.setTotalSeats(150);
        flight.setAvailableSeats(50 + random.nextInt(100));

        // price logic
        double basePrice = switch (route[1]) {
            case "Paris", "London", "New York" -> 40000;
            case "Dubai", "Doha" -> 20000;
            case "Singapore" -> 30000;
            default -> 25000;
        };

        // weekend surge
        if (date.getDayOfWeek().getValue() >= 5) {
            basePrice += 5000;
        }

        flight.setPrice(basePrice + random.nextInt(5000));

        // status logic
        flight.setStatus(random.nextInt(10) < 2 ? FlightStatus.DELAYED : FlightStatus.SCHEDULED);

        return flight;
    }
}