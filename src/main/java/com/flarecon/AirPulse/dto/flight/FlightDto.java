package com.flarecon.AirPulse.dto.flight;

import com.flarecon.AirPulse.model.Flight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long id;
    private String flightNumber;
    private String fromCity;
    private String toCity;
    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;
    private Double price;
    private Integer availableSeats;

    public FlightDto(Flight flight) {
        this.id = flight.getId();
        this.flightNumber = flight.getFlightNumber();
        this.fromCity = flight.getFromCity();
        this.toCity = flight.getToCity();
        this.departureTime = flight.getDepartureTime();
        this.arrivalTime = flight.getArrivalTime();
        this.price = flight.getPrice();
        this.availableSeats = flight.getAvailableSeats();
    }

    public Flight toEntity() {
        Flight flight = new Flight();
        flight.setFlightNumber(this.flightNumber);
        flight.setFromCity(this.fromCity);
        flight.setToCity(this.toCity);
        flight.setDepartureTime(this.departureTime);
        flight.setArrivalTime(this.arrivalTime);
        flight.setPrice(this.price);
        flight.setAvailableSeats(this.availableSeats);
        return flight;
    }
}

