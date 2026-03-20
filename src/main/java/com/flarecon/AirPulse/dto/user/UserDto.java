package com.flarecon.AirPulse.dto.user;

import com.flarecon.AirPulse.model.user.User;

public class UserDto {
    String uuid;
    String username;
    String name;
    String email;

    public UserDto(User user) {
        this.uuid = user.getUuid();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
