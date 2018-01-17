package com.grybos.kamil.patternsproject.factory;

import com.grybos.kamil.patternsproject.model.challenge.Challenge;
import com.grybos.kamil.patternsproject.model.challenge.ChallengeCategory;
import com.grybos.kamil.patternsproject.model.money.Money;
import com.grybos.kamil.patternsproject.model.user.Organizer;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

@Component
public class ChallengeFactory {

    private Logger logger = Logger.getLogger(ChallengeFactory.class);

    public Challenge create() {
        return new Challenge();
    }

    public Challenge create(Organizer organizer, ChallengeCategory category, String name, String description, Money money, long ratios[]) {
        List<Money> rewards = Arrays.asList(money.allocate(ratios));
        return new Challenge(organizer, category, name, description, rewards, ratios.length);
    }

    public Challenge create(Organizer organizer, ChallengeCategory category, String name, String description, Money money, int memberLimit) {
        List<Money> rewards = Arrays.asList(money.allocate(memberLimit));
        Optional<Money> reduce = rewards.stream().reduce(Money::add);
        return new Challenge(organizer, category, name, description, rewards, memberLimit);
    }

}
