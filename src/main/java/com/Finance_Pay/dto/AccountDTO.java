package com.Finance_Pay.dto;

import jakarta.annotation.Nonnull;

public record AccountDTO(

        @Nonnull
        Integer id,
        @Nonnull
        String accountNumber,
        @Nonnull
        double balance
) {
}
