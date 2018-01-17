package com.grybos.kamil.patternsproject.model.challenge.converter;

import com.grybos.kamil.patternsproject.model.challenge.Challenge;
import com.grybos.kamil.patternsproject.model.challenge.dto.ChallengeDTO;
import com.grybos.kamil.patternsproject.model.challenge.dto.ChallengePreviewDTO;
import com.grybos.kamil.patternsproject.model.challenge.dto.ChallengesDTO;

import java.util.List;

public class ChallengeConverter {

    public static ChallengeDTO toChallengeDTO(Challenge challenge) {
        return new ChallengeDTO(challenge);
    }

    public static ChallengePreviewDTO toChallengePreviewDTO(Challenge challenge) {
        return new ChallengePreviewDTO(challenge);
    }

    public static ChallengesDTO toChallengesDTO(List<Challenge> challenges) {
        return new ChallengesDTO(challenges);
    }


}
