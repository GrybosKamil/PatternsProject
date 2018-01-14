package com.grybos.kamil.patternsproject.controller;

import com.grybos.kamil.patternsproject.model.Member;
import com.grybos.kamil.patternsproject.model.factory.MemberFactory;
import com.grybos.kamil.patternsproject.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

//    @Autowired
//    UserService userService;
    @Autowired
    MemberService memberService;
    @Autowired
    MemberFactory memberFactory;
//    @Autowired
//    OrganizerService organizerService;

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    Member getMember(@RequestParam(value = "username") String username) {
        Member member = memberService.findByUsername(username);
//        if(organizerService.findByUsername(username) == null){
//            logger.info("No organizer nie znalazł");
//        }
//        if (member == null) {
//            logger.info("No member nie znalazł");
//            member = organizerService.findByUsername(username);
//        }
        if (member == null) {
            member = memberFactory.createNotFoundMember(username);
        }

        return member;
    }

}
