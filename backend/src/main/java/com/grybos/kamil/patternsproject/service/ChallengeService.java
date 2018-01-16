package com.grybos.kamil.patternsproject.service;

import com.grybos.kamil.patternsproject.factory.ChallengeFactory;
import com.grybos.kamil.patternsproject.factory.WalletFactory;
import com.grybos.kamil.patternsproject.model.challenge.Challenge;
import com.grybos.kamil.patternsproject.model.money.Money;
import com.grybos.kamil.patternsproject.model.money.Wallet;
import com.grybos.kamil.patternsproject.model.user.Member;
import com.grybos.kamil.patternsproject.model.user.Organizer;
import com.grybos.kamil.patternsproject.repository.ChallengeRepository;
import com.grybos.kamil.patternsproject.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChallengeService {

    @Autowired
    ChallengeRepository challengeRepository;
    @Autowired
    ChallengeFactory challengeFactory;

    private static final Logger logger = LoggerFactory.getLogger(ChallengeService.class);

    public void create(Organizer organizer, String name, String description, Money money, long ratios[]) {
        Challenge c = challengeFactory.create(organizer, name, description, money, ratios);
        challengeRepository.save(c);
    }

    public void create(Organizer organizer, String name, String description, Money money, int memberLimit) {
        Challenge c = challengeFactory.create(organizer, name, description, money, memberLimit);
        challengeRepository.save(c);
    }

//    public Challenge createNotFoundUser() {
//        return challengeFactory.createNotFoundUser();
//    }
//
//    public Challenge createClosedChallenge(String username) {
//        return challengeFactory.createNotFoundMember(username);
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

//    public int updateName(String username, String name) {
//        return challengeRepository.updateName(username, name);
//    }
}
