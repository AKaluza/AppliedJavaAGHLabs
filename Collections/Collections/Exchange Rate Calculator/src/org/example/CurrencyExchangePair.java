package org.example;

import java.util.Objects;

public class CurrencyExchangePair {

    private final String currencyFrom;
    private final String currencyTo;

    public CurrencyExchangePair(String currencyFrom, String currencyTo) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    @Override
    public String toString() {
        return "(" + currencyFrom + "->" + currencyTo + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyExchangePair)) return false;

        CurrencyExchangePair that = (CurrencyExchangePair) o;

      return Objects.equals(that.currencyFrom,currencyFrom) && Objects.equals(that.currencyTo,currencyTo);
    }

    @Override
    public int hashCode() {
        int result = currencyFrom != null ? currencyFrom.hashCode() : 0;
        result = 31 * result + (currencyTo != null ? currencyTo.hashCode() : 0);
        return result;
    }
}
