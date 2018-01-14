package com.grybos.kamil.patternsproject.database;

//import com.grybos.kamil.patternsproject.model.Money;
//import com.grybos.kamil.patternsproject.model.factory.MoneyFactory;
import com.grybos.kamil.patternsproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.Locale;

@Component
public class InitDatabase {

    private static final Logger logger = LoggerFactory.getLogger(InitDatabase.class);
    //    @Autowired
//    private final MoneyFactory moneyFactory;
    //    @Autowired
//    private WalletFactory walletFactory;
//    @Autowired
//    private UserService userService;

    @Autowired
    public InitDatabase(
//            MoneyFactory moneyFactory,
                        UserService userService) {
//        Money moneyUK = moneyFactory.create(1000, Currency.getInstance(Locale.UK));
//        Money moneyUS1 = moneyFactory.create(545, Currency.getInstance(Locale.US));
//        Money moneyUS2 = moneyFactory.create(545, Currency.getInstance(Locale.US));
//        Wallet walletMember = walletFactory.create(moneyUK);
//        Wallet walletOrganizer = walletFactory.create(Arrays.asList(moneyUK, moneyUS));
        userService.createMember("admin", "admin", "USER", 10000);
        userService.createMember("a", "a", "USER");
        userService.createOrganizer("q", "q", "USER", 10000);
        userService.createOrganizer("qw", "q", "USER", 500);
//        logger.info("" + moneyUS1.equals(moneyUS2));
//        userService.createOrganizer("qwe", "q", "USER", moneyUS1);
    }


}