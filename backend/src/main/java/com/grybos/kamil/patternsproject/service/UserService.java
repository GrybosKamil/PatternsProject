package com.grybos.kamil.patternsproject.service;

import com.grybos.kamil.patternsproject.factory.UserFactory;
import com.grybos.kamil.patternsproject.model.money.Wallet;
import com.grybos.kamil.patternsproject.model.user.Member;
import com.grybos.kamil.patternsproject.model.user.User;
import com.grybos.kamil.patternsproject.repository.UserRepository;
import com.grybos.kamil.patternsproject.security.jwt.JwtService;
import com.grybos.kamil.patternsproject.support.DateGenerator;
import com.grybos.kamil.patternsproject.support.StringSupport;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserService {

    @Autowired
    ShaPasswordEncoder shaPasswordEncoder;
    @Autowired
    StringSupport stringSupport;
    @Autowired
    JwtService jwtService;
    @Autowired
    DateGenerator dateGenerator;
    @Autowired
    UserFactory userFactory;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    OrganizerService organizerService;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public void create(String username, String password, String role) {
        String salt = stringSupport.generate();
        User u = userFactory.create(username, shaPasswordEncoder.encodePassword(password, salt), salt, role);
        userRepository.save(u);
    }

    public void createMember(String username, String password, String role) {
        create(username, password, role);
        memberService.create(username, username);
    }

    public void createMember(String username, String password, String role, Wallet wallet) {
        create(username, password, role);
        memberService.create(username, username, wallet);
    }

    public void createOrganizer(String username, String password, String role) {
        create(username, password, role);
        organizerService.create(username, username);
    }

    public void createOrganizer(String username, String password, String role, Wallet wallet) {
        create(username, password, role);
        organizerService.create(username, username, wallet);
    }

    public Member getMemmber(String token, String secret) {
        logger.info("getMember");
        String username = jwtService.getUsername(token, secret);
        Member member;
        if (username != null) {
            User user = userRepository.findByUsername(username);
            if (user != null && token.equals(user.getToken()) && jwtService.isValid(token, secret)) {
                member = memberService.findByUsername(username);
                if (member == null) {
                    member = memberService.createNotFoundMember(username);
                }
                return member;
            }
        }

        return memberService.createNotFoundUser();
    }

    public User isLoginValid(String username, String pass) {
        if (!StringUtils.hasText(username) || !StringUtils.hasText(pass)) {
            return null;
        }
        String password = new String(Base64.decodeBase64(pass.getBytes()));
        User u = userRepository.findByUsername(username);
        if (u == null) {
            return null;
        }

        if (!u.getPassword().equals(shaPasswordEncoder.encodePassword(password, u.getSalt()))) {
            return null;
        }

        return u;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User createUserToken(String username, String secret) {
        String token = jwtService.createToken(username, secret, dateGenerator.getExpirationDate());
        User u = userRepository.findByUsername(username);
        u.setToken(token);
        return userRepository.save(u);
    }

    public User validateUser(String token, String secret) {
        String username = jwtService.getUsername(token, secret);
        if (username != null) {
            User user = userRepository.findByUsername(username);
            if (user != null && token.equals(user.getToken()) && jwtService.isValid(token, secret)) {
                return user;
            }
        }
        return null;
    }
}
