package org.example;

import java.math.BigDecimal;

public class runME {
    public static void main(String[] args)  {
        System.out.println("Hello");
        ExchangeRateCalculator calculator;
        StaticDataProvider staticDataProvider = new StaticDataProvider();
        staticDataProvider.exchangeRatesMap.put(new CurrencyExchangePair("PLN", "GBP"), new BigDecimal("4.9431"));
        staticDataProvider.exchangeRatesMap.put(new CurrencyExchangePair("GBP", "PLN"), new BigDecimal("0.1905"));
        staticDataProvider.exchangeRatesMap.put(new CurrencyExchangePair("PLN", "USD"), new BigDecimal("2.9540"));
        staticDataProvider.exchangeRatesMap.put(new CurrencyExchangePair("USD", "PLN"), new BigDecimal("0.3187"));

        calculator = new ExchangeRateCalculator();
        calculator.staticDataProvider = staticDataProvider;
        System.out.println("Hello");
        try {
            String amount = Integer.toString(30);
            String currencyFrom = "PLN";
            String currencyTo = "GBP";
            System.out.println("amount:" + amount + new CurrencyExchangePair(currencyFrom,currencyTo)+
                    calculator.convertMoney(amount, currencyFrom, currencyTo));
        } catch (NoSuchExchangeRateException e) {
            e.printStackTrace();
        }
    }
}
