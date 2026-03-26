package com.flarecon.AirPulse.controller.flight;

import com.flarecon.AirPulse.model.flight.Flight;
import com.flarecon.AirPulse.service.flight.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    /**
     * Create a new flight
     * POST /api/flights
     */
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight createdFlight = flightService.createFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight);
    }

    /**
     * Get flight by ID
     * GET /api/flights/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id);
        return ResponseEntity.ok(flight);
    }

    /**
     * Get flight by flight number
     * GET /api/flights/number/{flightNumber}
     */
    @GetMapping("/number/{flightNumber}")
    public ResponseEntity<Flight> getFlightByFlightNumber(@PathVariable String flightNumber) {
        Flight flight = flightService.getFlightByFlightNumber(flightNumber);
        return ResponseEntity.ok(flight);
    }

    /**
     * Get all flights
     * GET /api/flights
     */
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    /**
     * Search flights by route
     * GET /api/flights/search?fromCity=NYC&toCity=LAX
     */
    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String fromCity,
            @RequestParam String toCity) {
        List<Flight> flights = flightService.searchFlightsByRoute(fromCity, toCity);
        return ResponseEntity.ok(flights);
    }

    /**
     * Get flights from a city
     * GET /api/flights/from/{fromCity}
     */
    @GetMapping("/from/{fromCity}")
    public ResponseEntity<List<Flight>> getFlightsByFromCity(@PathVariable String fromCity) {
        List<Flight> flights = flightService.getFlightsByFromCity(fromCity);
        return ResponseEntity.ok(flights);
    }

    /**
     * Get flights to a city
     * GET /api/flights/to/{toCity}
     */
    @GetMapping("/to/{toCity}")
    public ResponseEntity<List<Flight>> getFlightsByToCity(@PathVariable String toCity) {
        List<Flight> flights = flightService.getFlightsByToCity(toCity);
        return ResponseEntity.ok(flights);
    }

    /**
     * Update flight
     * PUT /api/flights/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(
            @PathVariable Long id,
            @RequestBody Flight flight) {
        Flight updatedFlight = flightService.updateFlight(id, flight);
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

