package com.grybos.kamil.patternsproject.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String name;

    //    @ManyToOne(cascade = CascadeType.ALL)
//    private Money money;
    @Column
    private long money;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member() {
    }

//    public void setWallet(Wallet wallet) {
//        this.wallet = wallet;
//    }
//
//    public Wallet getWallet() {
//        return wallet;
//    }

    public Member(String username, String name) {
        this.username = username;
        this.name = name;
    }

//    public Money getMoney() {
//        return money;
//    }

//    public void setMoney(Money money) {
//        this.money = money;
//    }

    public Member(String username, String name,
                  long money
//                  Money money
    ) {
        this.username = username;
        this.name = name;
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format(
                "Member[" +
                        "id=%d, " +
                        "username='%s', " +
                        "name='%s', " +
                        "money=[%s]" +
//                        "wallet=[%s]" +
                        "]",
                getId(), getUsername(), getName(), getMoney()
        );
    }

}
