package com.grybos.kamil.patternsproject.factory;

import com.grybos.kamil.patternsproject.model.money.Money;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Currency;

@Component
public class MoneyFactory {

    public Money create() {
        return new Money();
    }

    public Money create(BigDecimal amount, Currency currency) {
        return new Money(amount, currency);
    }

    public Money create(double amount, Currency currency) {
        return new Money(amount, currency);
    }

    public Money create(long amount, Currency currency) {
        return new Money(amount, currency);
    }
}
