package com.flarecon.AirPulse.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flarecon.AirPulse.Constants;
import com.flarecon.AirPulse.model.core.AbstractAuditingEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "users")
@Getter
@Setter
public final class User extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserGender gender;

    private LocalDate dob;

    @Transient
    private int age;

    @PostLoad
    @PostPersist
    @PostUpdate
    private void populateAgeFromDob() {
        this.age = calculateAge(this.dob);
    }

    public void setPlainPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(Constants.ENCODER_STRENGTH));
    }

    public boolean verifyPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }

    private static int calculateAge(LocalDate dob) {
        if (dob == null) {
            return 0;
        }

        final LocalDate today = LocalDate.now();
        if (dob.isAfter(today)) {
            return 0;
        }

        return Period.between(dob, today).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        return id != null && id.equals(((User) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
