package com.grybos.kamil.patternsproject.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //    @OneToMany(cascade = CascadeType.ALL) //ADDED
    @ElementCollection
    private List<String> monies;

    public List<String> getMonies() {
        return monies;
    }

    public void setMonies(List<String> monies) {
        this.monies = monies;
    }

    public Wallet() {
        this.monies = new ArrayList<>();
    }

//    public Wallet(List<Money> monies) {
//        this.monies = monies;
//    }
    public Wallet(List<String> monies) {
        this.monies = monies;
    }

//    public List<Money> getMonies() {
//        return monies;
//    }

//    public void setMonies(List<Money> monies) {
//        this.monies = monies;
//    }
//
//    void addMoney(Money money) {
//        Optional<Money> moneyOptional = monies.stream()
//                .filter(m -> m.getCurrency() == money.getCurrency())
//                .findFirst();
//
//        if (moneyOptional.isPresent()) {
//            Money money1 = moneyOptional.get();
//            monies.remove(money1);
//            monies.add(money1.add(money));
//        } else {
//            monies.add(money);
//        }
//    }
//
//    void substractMoney(Money money) throws Exception {
//        Optional<Money> moneyOptional = monies.stream()
//                .filter(m -> m.getCurrency() == money.getCurrency())
//                .findFirst();
//
//        if (moneyOptional.isPresent()) {
//            Money money1 = moneyOptional.get();
//            if (money1.greaterThan(money) || money1.equals(money)) {
//                monies.remove(money1);
//                monies.add(money1.subtract(money));
//            } else {
//                throw new Exception("Cannot substract money");
//            }
//        } else {
//            throw new Exception("Cannot substract money");
//        }
//    }

}
