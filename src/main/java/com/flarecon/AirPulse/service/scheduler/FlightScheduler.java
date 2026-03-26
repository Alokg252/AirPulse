package com.flarecon.AirPulse.service.scheduler;

import com.flarecon.AirPulse.model.flight.Flight;
import com.flarecon.AirPulse.repository.flight.FlightRepository;
import com.flarecon.AirPulse.service.flight.FlightGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class FlightScheduler {

    private final FlightRepository flightRepository;
    private final FlightGenerator generator;

    // Runs every 5 minutes
    @Scheduled(fixedRate = 300000)
    public void generateFlights() {

        for (int i = 0; i < 3; i++) {

            LocalDate date = LocalDate.now().plusDays(i);

            // generate 2 flights per route/day
            for (int j = 0; j < 2; j++) {

                Flight flight = generator.generateFlight(date);

                // avoid duplicates (same flightNumber + departure)
                if (!flightRepository.existsByFlightNumberAndDepartureTime(
                        flight.getFlightNumber(),
                        flight.getDepartureTime()
                )) {
                    flightRepository.save(flight);
                    log.info("Flight Scheduled from {} to {} available {} seats on {}",
                            flight.getFromCity(), flight.getToCity(), flight.getAvailableSeats(), flight.getDepartureTime());
                }
            }
        }

        log.info("Flight Generation Ended at {}", ZonedDateTime.now());
    }
}