package com.flarecon.AirPulse.model;

import com.flarecon.AirPulse.model.core.AbstractAuditingEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
public final class Flight extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_number", unique = true)
    private String flightNumber;

    @Column(name = "from_city")
    private String fromCity;

    @Column(name = "to_city")
    private String toCity;

    @Column(name = "departure_time")
    private ZonedDateTime departureTime;

    @Column(name = "arrival_time")
    private ZonedDateTime arrivalTime;

    private Double price;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof Flight)) return false;
        else return id != null && id.equals(((Flight) o).id);
    }

    @Override
    public int hashCode() {return getClass().hashCode();}
}