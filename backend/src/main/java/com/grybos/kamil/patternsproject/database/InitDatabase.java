package com.grybos.kamil.patternsproject.database;

import com.grybos.kamil.patternsproject.factory.MoneyFactory;
import com.grybos.kamil.patternsproject.factory.WalletFactory;
import com.grybos.kamil.patternsproject.model.challenge.Challenge;
import com.grybos.kamil.patternsproject.model.challenge.ChallengeCategory;
import com.grybos.kamil.patternsproject.model.money.Money;
import com.grybos.kamil.patternsproject.model.money.Wallet;
import com.grybos.kamil.patternsproject.model.user.Member;
import com.grybos.kamil.patternsproject.model.user.Organizer;
import com.grybos.kamil.patternsproject.service.ChallengeService;
import com.grybos.kamil.patternsproject.service.MemberService;
import com.grybos.kamil.patternsproject.service.OrganizerService;
import com.grybos.kamil.patternsproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Component
public class InitDatabase {

    private static final Logger logger = LoggerFactory.getLogger(InitDatabase.class);

    @Autowired
    public InitDatabase(
            MoneyFactory moneyFactory, WalletFactory walletFactory,
            UserService userService, MemberService memberService, OrganizerService organizerService,
            ChallengeService challengeService
    ) {
        Money moneyUK = moneyFactory.create(1000, Currency.getInstance(Locale.UK));
        Money moneyUS1 = moneyFactory.create(545, Currency.getInstance(Locale.US));
        Money moneyUS2 = moneyFactory.create(545, Currency.getInstance(Locale.US));
        Wallet walletMember = walletFactory.create(moneyUS1);
        Wallet walletOrganizer = walletFactory.create(Arrays.asList(moneyUS2, moneyUK));
        userService.createMember("admin", "admin", "USER", walletMember);
        userService.createMember("a", "a", "USER");
        userService.createOrganizer("q", "q", "USER", walletOrganizer);

        Member admin = memberService.findByName("admin");
        logger.info(admin.toString());
        Organizer q = (Organizer) memberService.findByName("q");
        logger.info(q.toString());

//        ChallengeCategory category = new ChallengeCategory("Running");

        String name = "Sprint 5 km";
        String description = "Run 5 km in 20 minutes";
        Optional<Money> optionalReward = q.getWallet().getMonies().stream().findFirst();
        Money allMoney = optionalReward
                .orElseGet(() -> moneyFactory.create(1000, Currency.getInstance(Locale.US)));

//        long ratios[] = new long[]{3, 4};
//        Money money = allMoney.allocate(ratios)[0];
        int memberLimit = 7;
        challengeService.create(q,
//                category,
                name, description, allMoney, memberLimit);


        Challenge challenge = challengeService.findByName(name);
        logger.info(challenge.toString());
        challenge.setParticipants(Arrays.asList(admin));
        challengeService.save(challenge);
    }


}