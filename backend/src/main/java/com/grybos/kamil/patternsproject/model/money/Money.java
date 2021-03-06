package com.grybos.kamil.patternsproject.model.money;

import org.jboss.logging.Logger;
import org.junit.Assert;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

@Embeddable
public class Money {

    private final long amount;
    private final Currency currency;

    private static final int[] cents = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
    private Logger logger = Logger.getLogger(Money.class);

    private int centFactor() {
        return cents[getCurrency().getDefaultFractionDigits()];
    }

    public Money() {
        this.amount = 0;
        this.currency = Currency.getInstance(Locale.US);
    }

    public Money(BigDecimal amount, Currency currency) {
        this.currency = currency;
        this.amount = amount.longValue();
    }

    public Money(double amount, Currency currency) {
        this.currency = currency;
        this.amount = Math.round(amount * centFactor());
    }

    public Money(long amount, Currency currency) {
        this.currency = currency;
        this.amount = amount * centFactor();
    }

    public Money(long amount, Currency currency, boolean useCentFactor) {
        this.currency = currency;
        if (useCentFactor) {
            this.amount = amount * centFactor();
        } else {
            this.amount = amount;
        }
    }

    public long getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal calculateAmount() {
        return BigDecimal.valueOf(getAmount(),
                getCurrency().getDefaultFractionDigits());
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Money) && equals((Money) other);
    }

    public boolean equals(Money other) {
        return getCurrency().equals(other.getCurrency()) &&
                (getAmount() == other.getAmount());
    }

    @Override
    public int hashCode() {
        return (int) (getAmount() ^ (getAmount() >>> 32));
    }

    private void assertSameCurrencyAs(Money arg) {
        Assert.assertEquals("money math mismatch", getCurrency(), arg.getCurrency());
    }

    public Money add(Money other) {
        assertSameCurrencyAs(other);
//        long amount1 = getAmount();
//        long amount2 = other.getAmount();
//
//        long amount3 = amount1 + amount2;
//        Money a = newMoney(amount3);
//        long amount = getAmount() + other.getAmount();
        return newMoney(getAmount() + other.getAmount());
    }

    public Money subtract(Money other) {
        assertSameCurrencyAs(other);
        return newMoney(getAmount() - other.getAmount());
    }

    private Money newMoney(long amount) {
        return new Money(amount, this.getCurrency(), false);
    }

    public int compareTo(Object other) {
        return compareTo((Money) other);
    }

    public int compareTo(Money other) {
        assertSameCurrencyAs(other);
        if (getAmount() < other.getAmount()) return -1;
        else if (getAmount() == other.getAmount()) return 0;
        else return 1;
    }

    public boolean greaterThan(Money other) {
        return (compareTo(other) > 0);
    }

    public boolean lesserThan(Money other) {
        return (compareTo(other) < 0);
    }

    public Money multiply(double amount) {
        return multiply(new BigDecimal(amount));
    }

    public Money multiply(BigDecimal amount) {
        return new Money(calculateAmount().multiply(amount),
                getCurrency());
    }

    public Money[] allocate(int n) {
        long partAmount = getAmount() / n;
        Money lowResult = newMoney(partAmount);
        Money highResult = newMoney(partAmount + 1);

        Money[] results = new Money[n];
        int remainder = (int) getAmount() % n;
        for (int i = 0; i < remainder; i++) {
            results[i] = highResult;
        }
        for (int i = remainder; i < n; i++) {
            results[i] = lowResult;
        }
        return results;
    }

    public Money[] allocate(long[] ratios) {
        if (ratios.length == 0 || ratios.length == 1) {
            return new Money[]{this};
        }

        if (getAmount() == 0) {
            Money[] monies = new Money[ratios.length];
            for (int i = 0; i < monies.length; i++) {
                monies[i] = newMoney(0);
            }
            return monies;
        }

        long total = 0;
        for (long ratio : ratios) {
            total += ratio;
        }
        long remainder = getAmount();
        long[] results = new long[ratios.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = getAmount() * ratios[i] / total;
            remainder -= results[i];
        }
        for (int i = 0; i < remainder; i++) {
            results[i]++;
        }

        Money[] monies = new Money[results.length];
        for (int i = 0; i < monies.length; i++) {
            monies[i] = newMoney(results[i]);
        }
        return monies;
    }

    @Override
    public String toString() {
        return String.format(
                "Money[" +
                        "amount='%d', " +
                        "currency='%s'" +
                        "]",
                getAmount(), getCurrency()
        );
    }
}