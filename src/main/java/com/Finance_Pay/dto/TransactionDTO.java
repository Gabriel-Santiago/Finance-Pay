package com.Finance_Pay.dto;

import jakarta.annotation.Nonnull;

import java.util.Date;

public record TransactionDTO(

        @Nonnull
        double value,
        @Nonnull
        Date date,
        @Nonnull
        String name,
        String description
) {
}