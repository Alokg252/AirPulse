package com.flarecon.AirPulse.service.scheduler;

import com.flarecon.AirPulse.model.flight.Flight;
import com.flarecon.AirPulse.model.flight.FlightStatus;
import com.flarecon.AirPulse.repository.flight.FlightRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class FlightLifecycleScheduler {

    private final FlightRepository flightRepository;

    @PostConstruct
    public void runOnStartup() {
        updateFlights();
    }

    @Scheduled(fixedRate = 20 * 60 * 1000) // 20 minutes
    public void scheduledRun() {
        updateFlights();
    }

    private void updateFlights() {

        ZonedDateTime now = ZonedDateTime.now();

        List<Flight> flights = flightRepository.findAll();

        for (Flight flight : flights) {

            // ✈️ 1. LANDING LOGIC
            if (FlightStatus.SCHEDULED.equals(flight.getStatus()) && flight.getArrivalTime().isBefore(now)) {
                flight.setStatus(FlightStatus.LANDED);
            }

            // 💰 2. PRICE LOGIC
            long hoursToDeparture = Duration.between(now, flight.getDepartureTime()).toHours();

            if (hoursToDeparture > 0) {

                // closer to departure → more expensive
                if (hoursToDeparture < 6) {
                    flight.setPrice(flight.getPrice() + 5000);
                } else if (hoursToDeparture < 24) {
                    flight.setPrice(flight.getPrice() + 2000);
                }

                // low seats → surge pricing
                if (flight.getAvailableSeats() < 20) {
                    flight.setPrice(flight.getPrice() + 3000);
                }
            }

            // 💺 3. SEAT REDUCTION (simulate bookings)
            if (FlightStatus.SCHEDULED.equals(flight.getStatus()) && flight.getAvailableSeats() > 0) {
                int booked = new Random().nextInt(5); // 0–4 seats per cycle
                int newSeats = Math.max(0, flight.getAvailableSeats() - booked);
                flight.setAvailableSeats(newSeats);
            }

            // 🚫 4. AUTO CANCEL (optional realism)
            if (flight.getAvailableSeats() == 0 && FlightStatus.SCHEDULED.equals(flight.getStatus())) {
                flight.setStatus(FlightStatus.FULL);
            }
        }

        flightRepository.saveAll(flights);

        System.out.println("Flight lifecycle updated at: " + now);
    }
}