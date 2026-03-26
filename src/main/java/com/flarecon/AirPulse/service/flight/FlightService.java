package com.flarecon.AirPulse.service.flight;

import com.flarecon.AirPulse.dto.flight.FlightDto;
import com.flarecon.AirPulse.model.flight.Flight;
import com.flarecon.AirPulse.repository.flight.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FlightService {

    private final FlightRepository flightRepository;

    /**
     * Save a new flight
     */
    public FlightDto createFlight(FlightDto flightDto) {
        Flight flight = flightDto.toEntity();
        Flight savedFlight = flightRepository.saveAndFlush(flight);
        return new FlightDto(savedFlight);
    }

    /**
     * Get flight by ID
     */
    public FlightDto getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));
        return new FlightDto(flight);
    }

    /**
     * Get flight by flight number
     */
    public FlightDto getFlightByFlightNumber(String flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new RuntimeException("Flight not found with number: " + flightNumber));
        return new FlightDto(flight);
    }

    /**
     * Get all flights
     */
    public List<FlightDto> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(FlightDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Search flights by route
     */
    public List<FlightDto> searchFlightsByRoute(String fromCity, String toCity) {
        return flightRepository.findByFromCityAndToCity(fromCity, toCity)
                .stream()
                .map(FlightDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Get flights from a city
     */
    public List<FlightDto> getFlightsByFromCity(String fromCity) {
        return flightRepository.findByFromCity(fromCity)
                .stream()
                .map(FlightDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Get flights to a city
     */
    public List<FlightDto> getFlightsByToCity(String toCity) {
        return flightRepository.findByToCity(toCity)
                .stream()
                .map(FlightDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Update flight
     */
    public FlightDto updateFlight(Long id, FlightDto flightDto) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));

        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setFromCity(flightDto.getFromCity());
        flight.setToCity(flightDto.getToCity());
        flight.setDepartureTime(flightDto.getDepartureTime());
        flight.setArrivalTime(flightDto.getArrivalTime());
        flight.setPrice(flightDto.getPrice());
        flight.setAvailableSeats(flightDto.getAvailableSeats());

        Flight updatedFlight = flightRepository.saveAndFlush(flight);
        return new FlightDto(updatedFlight);
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

