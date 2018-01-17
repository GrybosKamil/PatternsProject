package com.grybos.kamil.patternsproject.model.challenge.dto;

import com.grybos.kamil.patternsproject.model.challenge.Challenge;
import com.grybos.kamil.patternsproject.model.challenge.converter.ChallengeConverter;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ChallengesDTO {

    private List<ChallengePreviewDTO> challenges;

    public ChallengesDTO(List<Challenge> challenges) {
        this.challenges = challenges.stream()
                .map(ChallengeConverter::toChallengePreviewDTO)
                .collect(Collectors.toList());
    }
}
