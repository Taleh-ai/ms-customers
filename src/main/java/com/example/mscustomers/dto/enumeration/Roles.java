package com.example.mscustomers.dto.enumeration;


public enum Roles {
    STOCK_MANAGER("Stock Manager"),
    ORDER_MANAGER("Order Manager"),
    ADMIN("Admin");

    private final String displayName;

    Roles(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}