package com.Finance_Pay.enums;

public enum TypeOfIncomes {

    SALARY(0),
    INVESTMENT(1),
    RENTAL(2),
    RETIREMENT(3),
    ROYALTIES(4),
    SOCIAL_BENEFITS(5),
    OTHERS(6);

    public final int value;

    private TypeOfIncomes(int value){
        this.value = value;
    }
}
