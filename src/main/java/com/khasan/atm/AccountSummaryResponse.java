package com.khasan.atm;

public class AccountSummaryResponse {

    private String name;
    private boolean hasChecking;
    private boolean hasSavings;

    public AccountSummaryResponse(String name, boolean hasChecking, boolean hasSavings) {
        this.name = name;
        this.hasChecking = hasChecking;
        this.hasSavings = hasSavings;
    }

    public String getName() {
        return name;
    }

    public boolean isHasChecking() {
        return hasChecking;
    }

    public boolean isHasSavings() {
        return hasSavings;
    }
}