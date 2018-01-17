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
        ChallengeCategory challengeCategoryRunning = new ChallengeCategory("Running");
        Money moneyUK = moneyFactory.create(10000, Currency.getInstance(Locale.UK));
        Money moneyUS1 = moneyFactory.create(54522, Currency.getInstance(Locale.US));
        Money moneyUS2 = moneyFactory.create(54522, Currency.getInstance(Locale.US));

        Wallet walletMember = walletFactory.create(moneyUS1);
        Wallet walletOrganizer1 = walletFactory.create(Arrays.asList(moneyUS2, moneyUK));
        Wallet walletOrganizer2 = walletFactory.create(Arrays.asList(moneyUS1));
        userService.createMember("a", "a", "USER");
        userService.createMember("admin", "admin", "USER", walletMember);
        userService.createOrganizer("q1", "q1", "USER", walletOrganizer1);
        userService.createOrganizer("q2", "q2", "USER", walletOrganizer2);

        Member a = memberService.findByName("a");
        Member admin = memberService.findByName("admin");
        Organizer q1 = (Organizer) memberService.findByName("q1");
        Organizer q2 = (Organizer) memberService.findByName("q2");

        // Challenge1
        String challengeName1 = "Sprint 5 km";
        String challengeDescription1 = "Run 5 km in 20 minutes";
        Optional<Money> challengeOptionalReward1 = q1.getWallet().getMonies().stream().findFirst();
        Money challengeReward1 = challengeOptionalReward1
                .orElseGet(() -> moneyFactory.create(7200, Currency.getInstance(Locale.US)));

//        long ratios[] = new long[]{3, 4};
//        Money money = allMoney.allocate(ratios)[0];
        int challengeMemberLimit1 = 7;
        challengeService.create(q1, challengeCategoryRunning, challengeName1, challengeDescription1, challengeReward1, challengeMemberLimit1);

        Challenge challenge1 = challengeService.findByName(challengeName1);
        challenge1.setParticipants(Arrays.asList(admin, a));
        challengeService.save(challenge1);

        // Challenge1
        String challengeName2 = "Sprint 1 km";
        String challengeDescription2 = "Run 1 km under 3 minutes";
        Optional<Money> challengeOptionalReward2 = q1.getWallet().getMonies().stream().findFirst();

        Money challengeReward2 = challengeOptionalReward1
                .orElseGet(() -> moneyFactory.create(1600, Currency.getInstance(Locale.US)));

        challengeReward2 = new Money(1600, Currency.getInstance(Locale.US));
//        long ratios[] = new long[]{3, 4};
//        Money money = allMoney.allocate(ratios)[0];
        int challengeMemberLimit2 = 4;
        challengeService.create(q2, challengeCategoryRunning, challengeName2, challengeDescription2, challengeReward2, challengeMemberLimit2);

        Challenge challenge2 = challengeService.findByName(challengeName2);
        challenge1.setParticipants(Arrays.asList(admin));
        challengeService.save(challenge2);
    }
}