package com.flarecon.AirPulse.repository.flight;

import com.flarecon.AirPulse.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
    List<FlightBooking> findByUserId(Long userId);
    List<FlightBooking> findByFlightId(Long flightId);
}

