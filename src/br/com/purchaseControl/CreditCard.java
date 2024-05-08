package br.com.purchaseControl;

public class CreditCard {
    private double limit;

    public CreditCard(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    private void setLimit(double limit) {
        this.limit = limit;
    }

    public boolean purchase(double amount) {
        if (amount <= limit) {
            limit -= amount;
            return true;
        } else {
            return false;
        }
    }
}