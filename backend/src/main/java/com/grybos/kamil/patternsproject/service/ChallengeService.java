package com.grybos.kamil.patternsproject.service;

import com.grybos.kamil.patternsproject.factory.ChallengeFactory;
import com.grybos.kamil.patternsproject.model.challenge.Challenge;
import com.grybos.kamil.patternsproject.model.challenge.ChallengeCategory;
import com.grybos.kamil.patternsproject.model.money.Money;
import com.grybos.kamil.patternsproject.model.money.Wallet;
import com.grybos.kamil.patternsproject.model.user.Organizer;
import com.grybos.kamil.patternsproject.repository.ChallengeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ChallengeService {

    @Autowired
    ChallengeRepository challengeRepository;
    @Autowired
    ChallengeFactory challengeFactory;
    @Autowired
    OrganizerService organizerService;

    private static final Logger logger = LoggerFactory.getLogger(ChallengeService.class);

    public void create(Organizer organizer, ChallengeCategory category, String name, String description, Money money, long ratios[]) {
        Challenge c = challengeFactory.create(organizer, category, name, description, money, ratios);
        challengeRepository.save(c);
    }

    public void create(Organizer organizer, ChallengeCategory category, String name, String description, Money money, int memberLimit) {
        Wallet organizerWallet = organizer.getWallet();
        List<Money> organizerMonies = organizerWallet.getMonies();
        Optional<Money> moneyOptional = organizerMonies.stream().filter(x -> x.getCurrency() == money.getCurrency()).findFirst();

//        if (!moneyOptional.isPresent()) {
//            throw new InvalidArgumentException(new String[]{"No money to create challenge"});
//        }

        Money moneyToReduce = moneyOptional.get();
        Money moneyReduced = moneyToReduce.subtract(money);

//        if (moneyReduced.getAmount() < 0) {
//            throw new InvalidArgumentException(new String[]{"No enough money to create challenge"});
//        }
        organizerMonies = organizerMonies.stream().filter(x -> x.getCurrency() != money.getCurrency()).collect(Collectors.toList());
        organizerMonies.add(moneyReduced);

        organizerWallet.setMonies(organizerMonies);
        organizer.setWallet(organizerWallet);
        organizerService.save(organizer);

        Challenge c = challengeFactory.create(organizer, category, name, description, money, memberLimit);
        challengeRepository.save(c);
    }

//    public Challenge createNotFoundUser() {
//        return challengeFactory.createNotFoundUser();
//    }
//
//    public Challenge createClosedChallenge(String username) {
//        return challengeFactory.createNotFoundMemberByUsername(username);
//    }


    public Challenge findByName(String name) {
        return challengeRepository.findByName(name);
    }

    public List<Challenge> findByOwner(String owner) {
        return challengeRepository.findByOwner(owner);
    }

    public Challenge save(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    public List<Challenge> findAll() {
        return challengeRepository.findAll();
    }

//    public int updateName(String username, String name) {
//        return challengeRepository.updateName(username, name);
//    }
}
