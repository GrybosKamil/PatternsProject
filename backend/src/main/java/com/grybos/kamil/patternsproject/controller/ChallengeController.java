package com.grybos.kamil.patternsproject.controller;

import com.grybos.kamil.patternsproject.factory.MemberFactory;
import com.grybos.kamil.patternsproject.model.challenge.converter.ChallengeConverter;
import com.grybos.kamil.patternsproject.model.challenge.dto.ChallengesDTO;
import com.grybos.kamil.patternsproject.service.ChallengeService;
import com.grybos.kamil.patternsproject.service.MemberService;
import com.grybos.kamil.patternsproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {

    private static final Logger logger = LoggerFactory.getLogger(ChallengeController.class);

    @Autowired
    UserService userService;
    @Autowired
    MemberService memberService;
    @Autowired
    MemberFactory memberFactory;
    @Autowired
    ChallengeService challengeService;

//    @RequestMapping(method = RequestMethod.GET, value = "/get")
//    Member getMember(Authentication authentication,@RequestParam(value = "username") String username) {
//        Member member = memberService.findByUsername(username);
////        if(organizerService.findByUsername(username) == null){
////            logger.info("No organizer nie znalazł");
////        }
////        if (member == null) {
////            logger.info("No member nie znalazł");
////            member = organizerService.findByUsername(username);
////        }
//        if (member == null) {
//            member = memberFactory.createNotFoundMemberByUsername(username);
//        }
//
//        return member;
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    ChallengesDTO getChallenges() {
        return ChallengeConverter.toChallengesDTO(challengeService.findAll());
    }


//    @RequestMapping(method = RequestMethod.GET, value = "/changename")
//    Member changeName(@RequestParam(value = "username") String username, @RequestParam(value = "name") String name) {
//        logger.info(name);
//        Member member = memberService.findByUsername(username);
//        if (member == null) {
//            member = memberFactory.createNotFoundMemberByUsername(username);
//        } else {
//            Member m2 = memberService.findByName(name);
//            if (m2 == null) {
//                logger.info("change?");
//                member.setName(name);
//                Member m3 = memberService.save(member);
//                logger.info(m3.toString());
////                int affectedRows = memberService.updateName(username, name);
////                if (affectedRows > 0) {
//////                member.setName(name);
////                    logger.info("CHANGE!");
////                    memberService.save(member);
////                    member = memberService.findByUsername(username);
////                }
//            } else {
//                logger.info(m2.toString());
//            }
//        }
//
//        logger.info(member.toString());
//        return member;
//    }

//    @RequestMapping(method = RequestMethod.GET, value = "/changename")
//    Member changeName(Authentication authentication, @RequestParam(value = "name") String name) {
//        String username = (String) authentication.getPrincipal();
//        Member member = memberService.findByUsername(username);
//        if (member == null) {
//            member = memberFactory.createNotFoundMemberByUsername(username);
//        } else {
//            Member m2 = memberService.findByName(name);
//            if (m2 == null) {
//                member.setName(name);
//                Member m3 = memberService.save(member);
//                logger.info(m3.toString());
////                int affectedRows = memberService.updateName(username, name);
////                if (affectedRows > 0) {
//////                member.setName(name);
////                    logger.info("CHANGE!");
////                    memberService.save(member);
////                    member = memberService.findByUsername(username);
////                }
//            } else {
//                logger.info(m2.toString());
//            }
//        }
//
//        logger.info(member.toString());
//        return member;
//    }


//    @RequestMapping(method = RequestMethod.GET, value = "/delete")
//    int delete(Authentication authentication) {
//        String username = (String) authentication.getPrincipal();
//        User user = userService.findByUsername(username);
//
//
//        userService.delete(user);
//
//        user = userService.findByUsername(username);
//        if (user != null) {
//            return 500;
//        }
//        return 200;
//    }
}
