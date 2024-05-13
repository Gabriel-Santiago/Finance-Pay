package com.Finance_Pay.dto;

import jakarta.annotation.Nonnull;

public record FinancialManagementDTO(

        @Nonnull
        Integer id,
        double value,
        @Nonnull
        String name
) {
}
