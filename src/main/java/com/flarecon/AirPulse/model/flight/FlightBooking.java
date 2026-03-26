package com.flarecon.AirPulse.model.flight;

import com.flarecon.AirPulse.model.core.AbstractAuditingEntity;
import com.flarecon.AirPulse.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "flight_booking")
@Getter
@Setter
public final class FlightBooking extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
