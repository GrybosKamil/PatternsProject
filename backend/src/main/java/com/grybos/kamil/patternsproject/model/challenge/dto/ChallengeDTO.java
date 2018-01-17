package com.grybos.kamil.patternsproject.model.challenge.dto;

import com.grybos.kamil.patternsproject.model.challenge.Challenge;
import com.grybos.kamil.patternsproject.model.challenge.ChallengeCategory;
import com.grybos.kamil.patternsproject.model.money.Money;
import com.grybos.kamil.patternsproject.model.user.converter.MemberConverter;
import com.grybos.kamil.patternsproject.model.user.converter.OrganizerConverter;
import com.grybos.kamil.patternsproject.model.user.dto.MemberDTO;
import com.grybos.kamil.patternsproject.model.user.dto.OrganizerDTO;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ChallengeDTO {

    private Integer id;
    private OrganizerDTO owner;

    private String name;
    private String description;
    private ChallengeCategory category;

    private Integer memberLimit;
    private List<Money> rewards;

    private List<MemberDTO> participants;

    public ChallengeDTO(Challenge challenge) {
        this.id = challenge.getId();
        this.owner = OrganizerConverter.toOrganizerDTO(challenge.getOwner());
        this.name = challenge.getName();
        this.category = challenge.getCategory();
        this.memberLimit = challenge.getMemberLimit();
        this.rewards = challenge.getRewards();
        this.participants = challenge.getParticipants().stream().map(MemberConverter::toMemberDTO).collect(Collectors.toList());
    }

}
