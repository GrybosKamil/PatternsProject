package com.grybos.kamil.patternsproject.factory;

import com.grybos.kamil.patternsproject.model.money.Wallet;
import com.grybos.kamil.patternsproject.model.user.Member;
import com.grybos.kamil.patternsproject.model.user.MemberNotFound;
import org.springframework.stereotype.Component;

@Component
public class MemberFactory {

    public Member create(String username, String name) {
        return new Member(username, name);
    }

    public Member create(String username, String name, Wallet wallet) {
        return new Member(username, name, wallet);
    }

    public MemberNotFound createNotFoundMemberByUsername(String username) {
        return new MemberNotFound(username, "Not found member");
    }

    public MemberNotFound createNotFoundMemberByName(String name) {
        return new MemberNotFound("Not found member", name);
    }


    public MemberNotFound createNotFoundUser() {
        return new MemberNotFound("Not found user", "Not found member");
    }
}
