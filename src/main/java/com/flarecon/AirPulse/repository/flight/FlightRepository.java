package com.flarecon.AirPulse.repository.flight;

import com.flarecon.AirPulse.model.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByFromCityAndToCity(String fromCity, String toCity);
    List<Flight> findByFromCity(String fromCity);
    List<Flight> findByToCity(String toCity);
    List<Flight> findByFromCityAndToCityAndDepartureTimeBetween(
            String from,
            String to,
            ZonedDateTime start,
            ZonedDateTime end
    );
    boolean existsByFlightNumberAndDepartureTime(String flightNumber, ZonedDateTime departureTime);
}

