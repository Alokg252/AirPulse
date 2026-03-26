package com.flarecon.AirPulse.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flarecon.AirPulse.Constants;
import com.flarecon.AirPulse.model.core.AbstractAuditingEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDate;

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

    public void setPlainPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(Constants.ENCODER_STRENGTH));
    }

    public boolean verifyPassword(String password) {
        return BCrypt.checkpw(password, this.password);
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
