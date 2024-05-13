package com.Finance_Pay.enums;

public enum Type {
    HOUSING(0),
    FOOD(1),
    EDUCATION(2),
    TRANSPORTATION(3),
    ENTERTAINMENT(4),
    FINANCIAL(5),
    HEALTH(6),
    SAVINGS(7),
    INVESTMENTS(8);

    public final int value;

    private Type(int value){
        this.value = value;
    }
}
