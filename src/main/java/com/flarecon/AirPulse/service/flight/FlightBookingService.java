package com.flarecon.AirPulse.service.flight;

import com.flarecon.AirPulse.dto.flight.FlightBookingDto;
import com.flarecon.AirPulse.model.flight.Flight;
import com.flarecon.AirPulse.model.flight.FlightBooking;
import com.flarecon.AirPulse.model.user.User;
import com.flarecon.AirPulse.repository.flight.FlightBookingRepository;
import com.flarecon.AirPulse.repository.flight.FlightRepository;
import com.flarecon.AirPulse.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FlightBookingService {

    private final FlightBookingRepository flightBookingRepository;
    private final FlightRepository flightRepository;
    private final UserRepository userRepository;

    /**
     * Create a flight booking
     */
    public FlightBookingDto createBooking(Long flightId, Long userId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + flightId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Check if seats are available
        if (flight.getAvailableSeats() <= 0) {
            throw new RuntimeException("No available seats for this flight");
        }

        // Create booking
        FlightBooking booking = new FlightBooking();
        booking.setFlight(flight);
        booking.setUser(user);

        // Decrease available seats
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepository.saveAndFlush(flight);

        FlightBooking savedBooking = flightBookingRepository.saveAndFlush(booking);
        return new FlightBookingDto(savedBooking);
    }

    /**
     * Get booking by ID
     */
    public FlightBookingDto getBookingById(Long id) {
        FlightBooking booking = flightBookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
        return new FlightBookingDto(booking);
    }

    /**
     * Get all bookings for a user
     */
    public List<FlightBookingDto> getBookingsByUserId(Long userId) {
        return flightBookingRepository.findByUserId(userId)
                .stream()
                .map(FlightBookingDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Get all bookings for a flight
     */
    public List<FlightBookingDto> getBookingsByFlightId(Long flightId) {
        return flightBookingRepository.findByFlightId(flightId)
                .stream()
                .map(FlightBookingDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Get all bookings
     */
    public List<FlightBookingDto> getAllBookings() {
        return flightBookingRepository.findAll()
                .stream()
                .map(FlightBookingDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Cancel a booking
     */
    public void cancelBooking(Long id) {
        FlightBooking booking = flightBookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));

        // Increase available seats
        Flight flight = booking.getFlight();
        flight.setAvailableSeats(flight.getAvailableSeats() + 1);
        flightRepository.saveAndFlush(flight);

        flightBookingRepository.deleteById(id);
    }
}

