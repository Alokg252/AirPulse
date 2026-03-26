package com.flarecon.AirPulse.service.flight;

import com.flarecon.AirPulse.model.flight.Flight;
import com.flarecon.AirPulse.repository.flight.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FlightService {

    private final FlightRepository flightRepository;

    /**
     * Save a new flight
     */
    public Flight createFlight(Flight flight) {
        return flightRepository.saveAndFlush(flight);
    }

    /**
     * Get flight by ID
     */
    public Flight getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));
        return flight;
    }

    /**
     * Get flight by flight number
     */
    public Flight getFlightByFlightNumber(String flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new RuntimeException("Flight not found with number: " + flightNumber));
        return flight;
    }

    /**
     * Get all flights
     */
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    /**
     * Search flights by route
     */
    public List<Flight> searchFlightsByRoute(String fromCity, String toCity) {
        return flightRepository.findByFromCityAndToCity(fromCity, toCity);
    }

    /**
     * Get flights from a city
     */
    public List<Flight> getFlightsByFromCity(String fromCity) {
        return flightRepository.findByFromCity(fromCity);
    }

    /**
     * Get flights to a city
     */
    public List<Flight> getFlightsByToCity(String toCity) {
        return flightRepository.findByToCity(toCity);
    }

    /**
     * Update flight
     */
    public Flight updateFlight(Long id, Flight requestFlight) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));

        flight.setFlightNumber(requestFlight.getFlightNumber());
        flight.setFromCity(requestFlight.getFromCity());
        flight.setToCity(requestFlight.getToCity());
        flight.setDepartureTime(requestFlight.getDepartureTime());
        flight.setArrivalTime(requestFlight.getArrivalTime());
        flight.setPrice(requestFlight.getPrice());
        flight.setAvailableSeats(requestFlight.getAvailableSeats());
        flight.setTotalSeats(requestFlight.getTotalSeats());
        flight.setStatus(requestFlight.getStatus());

        return flightRepository.saveAndFlush(flight);
    }

    /**
     * Delete flight
     */
    public void deleteFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new RuntimeException("Flight not found with id: " + id);
        }
        flightRepository.deleteById(id);
    }
}

