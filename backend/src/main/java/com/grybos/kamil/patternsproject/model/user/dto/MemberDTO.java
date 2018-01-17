package com.grybos.kamil.patternsproject.model.user.dto;

import com.grybos.kamil.patternsproject.model.user.Member;
import lombok.Data;

@Data
public class MemberDTO {

    private Integer id;
    private String name;

    public MemberDTO(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }

}
