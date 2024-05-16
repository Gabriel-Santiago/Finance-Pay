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
        String cep,
        @Nonnull
        String email,
        @Nonnull
        String phone
) {
}
