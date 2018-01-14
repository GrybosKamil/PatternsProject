package com.grybos.kamil.patternsproject.model.factory;

import com.grybos.kamil.patternsproject.model.Money;
import com.grybos.kamil.patternsproject.model.Wallet;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class WalletFactory {

    public Wallet create() {
        return new Wallet();
    }

//    public Wallet create(String money) {
//        return create(Arrays.asList(money));
//    }
//
//    public Wallet create(List<String> monies) {
//        return new Wallet(monies);
//    }
    public Wallet create(Money money) {
        return create(Arrays.asList(money));
    }

    public Wallet create(List<Money> monies) {
        return new Wallet(monies);
    }
}
