package com.flarecon.AirPulse.dto.flight;

import com.flarecon.AirPulse.model.FlightBooking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingDto {
    private Long id;
    private Long flightId;
    private Long userId;
    private String flightNumber;
    private String fromCity;
    private String toCity;
    private String userName;

    public FlightBookingDto(FlightBooking flightBooking) {
        this.id = flightBooking.getId();
        this.flightId = flightBooking.getFlight().getId();
        this.userId = flightBooking.getUser().getId();
        this.flightNumber = flightBooking.getFlight().getFlightNumber();
        this.fromCity = flightBooking.getFlight().getFromCity();
        this.toCity = flightBooking.getFlight().getToCity();
        this.userName = flightBooking.getUser().getName();
    }
}

