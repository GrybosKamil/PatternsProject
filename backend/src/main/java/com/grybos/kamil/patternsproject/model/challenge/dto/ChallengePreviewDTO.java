package com.grybos.kamil.patternsproject.model.challenge.dto;

import com.grybos.kamil.patternsproject.model.challenge.Challenge;
import com.grybos.kamil.patternsproject.model.money.Money;
import com.grybos.kamil.patternsproject.model.user.converter.OrganizerConverter;
import com.grybos.kamil.patternsproject.model.user.dto.OrganizerDTO;
import lombok.Data;

import java.util.List;

@Data
public class ChallengePreviewDTO {

    private Integer id;
    private OrganizerDTO owner;
    private List<Money> rewards;
    private String name;
    private Integer memberLimit;
    private Integer numberOfParticipants;

    public ChallengePreviewDTO(Challenge challenge) {
        this.id = challenge.getId();
        this.owner = OrganizerConverter.toOrganizerDTO(challenge.getOwner());
        this.name = challenge.getName();
        this.rewards = challenge.getRewards();
        this.memberLimit = challenge.getMemberLimit();
        this.numberOfParticipants = challenge.getParticipants().size();

    }
}
