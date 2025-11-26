package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticDataProviderTest {
    private static ExchangeRateCalculator calculator;

    @Test
    public void testGBPtoPLN() throws Exception {
        final var actual = Assertions.assertDoesNotThrow(() -> calculator.convertMoney("3", "GBP", "PLN"));
        assertEquals(new BigDecimal("0.5715"), actual);
    }

    @Test
    public void testPLNtoGBP() throws Exception {
        final var actual = Assertions.assertDoesNotThrow(() -> calculator.convertMoney("30", "PLN", "GBP"));
        assertEquals(new BigDecimal("148.2930"), actual);
    }

    @BeforeAll
    public static void prepareTest() {
        final var staticDataProvider = initStatic();

        calculator = new ExchangeRateCalculator();
        calculator.staticDataProvider = staticDataProvider;
    }

    private static StaticDataProvider initStatic() {
        final var staticDataProvider = new StaticDataProvider();
        staticDataProvider.exchangeRatesMap.put(new CurrencyExchangePair("PLN", "GBP"), new BigDecimal("4.9431"));
        staticDataProvider.exchangeRatesMap.put(new CurrencyExchangePair("GBP", "PLN"), new BigDecimal("0.1905"));
        staticDataProvider.exchangeRatesMap.put(new CurrencyExchangePair("PLN", "USD"), new BigDecimal("2.9540"));
        staticDataProvider.exchangeRatesMap.put(new CurrencyExchangePair("USD", "PLN"), new BigDecimal("0.3187"));
        return staticDataProvider;
    }
}
