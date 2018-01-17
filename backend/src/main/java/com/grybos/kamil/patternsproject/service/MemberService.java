package com.grybos.kamil.patternsproject.service;

import com.grybos.kamil.patternsproject.factory.MemberFactory;
import com.grybos.kamil.patternsproject.factory.WalletFactory;
import com.grybos.kamil.patternsproject.model.money.Wallet;
import com.grybos.kamil.patternsproject.model.user.Member;
import com.grybos.kamil.patternsproject.model.user.MemberNotFound;
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
    @Autowired
    WalletFactory walletFactory;

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    public void create(String username, String name) {
        Member m = memberFactory.create(username, name, walletFactory.create());
        memberRepository.save(m);
    }

    public void create(String username, String name, Wallet wallet) {
        Member m = memberFactory.create(username, name, wallet);
        memberRepository.save(m);
    }

    public MemberNotFound createNotFoundUser() {
        return memberFactory.createNotFoundUser();
    }

    public MemberNotFound createNotFoundMemberByUsername(String username) {
        return memberFactory.createNotFoundMemberByUsername(username);
    }

    public MemberNotFound createNotFoundMemberByName(String name) {
        return memberFactory.createNotFoundMemberByName(name);
    }

    public Member findByUsername(String username) {
        Member member = memberRepository.findByUsername(username);
        if (member == null) {
            member = memberFactory.createNotFoundMemberByUsername(username);
        }
        return member;
    }

    public Member findByName(String name) {
        Member member = memberRepository.findByName(name);
        if (member == null) {
            member = memberFactory.createNotFoundMemberByName(name);
        }
        return member;
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public int updateName(String username, String name) {
        return memberRepository.updateName(username, name);
    }
}
