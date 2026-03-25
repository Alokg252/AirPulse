package com.flarecon.AirPulse.controller.flight;

import com.flarecon.AirPulse.dto.flight.FlightDto;
import com.flarecon.AirPulse.service.flight.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    /**
     * Create a new flight
     * POST /api/flights
     */
    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        FlightDto createdFlight = flightService.createFlight(flightDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight);
    }

    /**
     * Get flight by ID
     * GET /api/flights/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Long id) {
        FlightDto flight = flightService.getFlightById(id);
        return ResponseEntity.ok(flight);
    }

    /**
     * Get flight by flight number
     * GET /api/flights/number/{flightNumber}
     */
    @GetMapping("/number/{flightNumber}")
    public ResponseEntity<FlightDto> getFlightByFlightNumber(@PathVariable String flightNumber) {
        FlightDto flight = flightService.getFlightByFlightNumber(flightNumber);
        return ResponseEntity.ok(flight);
    }

    /**
     * Get all flights
     * GET /api/flights
     */
    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<FlightDto> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    /**
     * Search flights by route
     * GET /api/flights/search?fromCity=NYC&toCity=LAX
     */
    @GetMapping("/search")
    public ResponseEntity<List<FlightDto>> searchFlights(
            @RequestParam String fromCity,
            @RequestParam String toCity) {
        List<FlightDto> flights = flightService.searchFlightsByRoute(fromCity, toCity);
        return ResponseEntity.ok(flights);
    }

    /**
     * Get flights from a city
     * GET /api/flights/from/{fromCity}
     */
    @GetMapping("/from/{fromCity}")
    public ResponseEntity<List<FlightDto>> getFlightsByFromCity(@PathVariable String fromCity) {
        List<FlightDto> flights = flightService.getFlightsByFromCity(fromCity);
        return ResponseEntity.ok(flights);
    }

    /**
     * Get flights to a city
     * GET /api/flights/to/{toCity}
     */
    @GetMapping("/to/{toCity}")
    public ResponseEntity<List<FlightDto>> getFlightsByToCity(@PathVariable String toCity) {
        List<FlightDto> flights = flightService.getFlightsByToCity(toCity);
        return ResponseEntity.ok(flights);
    }

    /**
     * Update flight
     * PUT /api/flights/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> updateFlight(
            @PathVariable Long id,
            @RequestBody FlightDto flightDto) {
        FlightDto updatedFlight = flightService.updateFlight(id, flightDto);
        return ResponseEntity.ok(updatedFlight);
    }

    /**
     * Delete flight
     * DELETE /api/flights/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}

