package com.grybos.kamil.patternsproject.service;

import com.grybos.kamil.patternsproject.model.Member;
//import com.grybos.kamil.patternsproject.model.Money;
import com.grybos.kamil.patternsproject.model.factory.MemberFactory;
import com.grybos.kamil.patternsproject.repository.MemberRepository;
import com.grybos.kamil.patternsproject.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MemberFactory memberFactory;

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    public void create(String username, String name) {
        logger.info("create");
        Member m = memberFactory.create(username, name);
        memberRepository.save(m);
    }

    public void create(String username, String name,
                       long money
//            Money money
    ) {
        logger.info("create");
        Member m = memberFactory.create(username, name, money);
        memberRepository.save(m);
    }

    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public Member createNotFoundUser() {
        return memberFactory.createNotFoundUser();
    }

    public Member createNotFoundMember(String username) {
        return memberFactory.createNotFoundMember(username);
    }
}
