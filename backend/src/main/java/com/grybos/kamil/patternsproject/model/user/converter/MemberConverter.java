package com.grybos.kamil.patternsproject.model.user.converter;

import com.grybos.kamil.patternsproject.model.user.Member;
import com.grybos.kamil.patternsproject.model.user.dto.MemberDTO;

public class MemberConverter {

    public static MemberDTO toMemberDTO(Member member){
        return new MemberDTO(member);
    }
}
