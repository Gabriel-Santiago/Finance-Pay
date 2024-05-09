package com.Finance_Pay.dto;

import jakarta.annotation.Nonnull;

public record PersonDTO(

        @Nonnull
        Integer id,
        @Nonnull
        String name,
        @Nonnull
        String city,
        @Nonnull
        String state,
        @Nonnull
        String email,
        @Nonnull
        String password,
        @Nonnull
        String phone
) {
}
