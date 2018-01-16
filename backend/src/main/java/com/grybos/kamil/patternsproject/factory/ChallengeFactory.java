package com.grybos.kamil.patternsproject.factory;

import com.grybos.kamil.patternsproject.model.challenge.Challenge;
import com.grybos.kamil.patternsproject.model.money.Money;
import com.grybos.kamil.patternsproject.model.user.Organizer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

@Component
public class ChallengeFactory {

    public Challenge create() {
        return new Challenge();
    }

    public Challenge create(Organizer organizer, String name, String description, Money money, int memberLimit) {
        List<Money> rewards = Arrays.asList(money.allocate(memberLimit));
        return new Challenge(organizer, name, description, rewards, memberLimit);
    }

    public Challenge create(Organizer organizer, String name, String description, Money money, long ratios[]) {
        List<Money> rewards = Arrays.asList(money.allocate(ratios));
        return new Challenge(organizer, name, description, rewards, ratios.length);
    }

}
