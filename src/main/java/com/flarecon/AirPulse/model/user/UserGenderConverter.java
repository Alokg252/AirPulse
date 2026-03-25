package com.flarecon.AirPulse.model.user;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UserGenderConverter implements AttributeConverter<UserGender, String> {

    @Override
    public String convertToDatabaseColumn(UserGender attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public UserGender convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }

        String normalized = dbData.trim().toUpperCase();

        // Backward compatibility for legacy numeric enum values stored as text.
        if (normalized.matches("\\d+")) {
            int ordinal = Integer.parseInt(normalized);
            UserGender[] values = UserGender.values();
            if (ordinal >= 0 && ordinal < values.length) {
                return values[ordinal];
            }
            return UserGender.NOT_SPECIFIED;
        }

        try {
            return UserGender.valueOf(normalized);
        } catch (IllegalArgumentException ignored) {
            return UserGender.NOT_SPECIFIED;
        }
    }
}

