package com.Finance_Pay.dto;

import jakarta.annotation.Nonnull;

import java.util.Date;

public record GoalDTO(

        @Nonnull
        double value,
        @Nonnull
        String name,
        String description,
        @Nonnull
        Date dayOfPurchase
) {
}