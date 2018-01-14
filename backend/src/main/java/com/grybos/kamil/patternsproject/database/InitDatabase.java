package com.grybos.kamil.patternsproject.database;

import com.grybos.kamil.patternsproject.model.Money;
import com.grybos.kamil.patternsproject.model.Wallet;
import com.grybos.kamil.patternsproject.model.factory.MoneyFactory;
import com.grybos.kamil.patternsproject.model.factory.WalletFactory;
import com.grybos.kamil.patternsproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

@Component
public class InitDatabase {

    private static final Logger logger = LoggerFactory.getLogger(InitDatabase.class);

    @Autowired
    public InitDatabase(
//            MoneyFactory moneyFactory,
                        WalletFactory walletFactory, UserService userService) {
//        Money moneyUK = moneyFactory.create(1000, Currency.getInstance(Locale.UK));
//        Money moneyUS1 = moneyFactory.create(545, Currency.getInstance(Locale.US));
//        Money moneyUS2 = moneyFactory.create(545, Currency.getInstance(Locale.US));
        Wallet walletMember = walletFactory.create("1000");
        Wallet walletOrganizer = walletFactory.create(Arrays.asList("3213", "321421"));
        userService.createMember("admin", "admin", "USER", walletMember);
        userService.createMember("a", "a", "USER");
        userService.createOrganizer("q", "q", "USER", walletOrganizer);
    }


}