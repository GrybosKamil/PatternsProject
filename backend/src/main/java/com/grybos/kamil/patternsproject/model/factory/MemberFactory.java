package com.grybos.kamil.patternsproject.model.factory;

import com.grybos.kamil.patternsproject.model.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberFactory {

    public Member create(String username, String name) {
        return new Member(username, name);
    }

    public Member createNotFoundMember(String username) {
        return new Member(username, "Not found member");
    }
    public Member createNotFoundUser() {
        return new Member("Not found user", "Not found member");
    }
}
