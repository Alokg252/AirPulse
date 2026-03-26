package com.flarecon.AirPulse.controller.flight;

import com.flarecon.AirPulse.model.flight.FlightBooking;
import com.flarecon.AirPulse.service.flight.FlightBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    /**
     * Create a flight booking
     * POST /api/bookings
     * Request body: { "flightId": 1, "userId": 1 }
     */
    @PostMapping
    public ResponseEntity<FlightBooking> createBooking(@RequestBody Map<String, Long> request) {
        Long flightId = request.get("flightId");
        Long userId = request.get("userId");
        FlightBooking booking = flightBookingService.createBooking(flightId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }

    /**
     * Get booking by ID
     * GET /api/bookings/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<FlightBooking> getBookingById(@PathVariable Long id) {
        FlightBooking booking = flightBookingService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    /**
     * Get all bookings for a user
     * GET /api/bookings/user/{userId}
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FlightBooking>> getBookingsByUserId(@PathVariable Long userId) {
        List<FlightBooking> bookings = flightBookingService.getBookingsByUserId(userId);
        return ResponseEntity.ok(bookings);
    }

    /**
     * Get all bookings for a flight
     * GET /api/bookings/flight/{flightId}
     */
    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<FlightBooking>> getBookingsByFlightId(@PathVariable Long flightId) {
        List<FlightBooking> bookings = flightBookingService.getBookingsByFlightId(flightId);
        return ResponseEntity.ok(bookings);
    }

    /**
     * Get all bookings
     * GET /api/bookings
     */
    @GetMapping
    public ResponseEntity<List<FlightBooking>> getAllBookings() {
        List<FlightBooking> bookings = flightBookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    /**
     * Cancel a booking
     * DELETE /api/bookings/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        flightBookingService.cancelBooking(id);
        return ResponseEntity.noContent().build();
    }
}

