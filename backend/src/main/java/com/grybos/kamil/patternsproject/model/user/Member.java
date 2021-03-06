package com.grybos.kamil.patternsproject.model.user;

import com.grybos.kamil.patternsproject.model.money.Wallet;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @OneToOne(cascade = CascadeType.ALL)
    private Wallet wallet;
//    @LazyCollection(LazyCollectionOption.TRUE)
//    @ManyToMany
//    private List<Challenge> challenges;

    //    public List<Challenge> getChallenges() {
//        return challenges;
//    }
//
//    public void setChallenges(List<Challenge> challenges) {
//        this.challenges = challenges;
//    }

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

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Member() {
    }

    public Member(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public Member(String username, String name, Wallet wallet) {
        this.username = username;
        this.name = name;
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return String.format(
                "Member[" +
                        "id=%d, " +
                        "username='%s', " +
                        "name='%s', " +
                        "wallet=[%s]" +
//                        "challenges=[%d]" +
                        "]",
                getId(), getUsername(), getName(), getWallet()
//                , getChallenges().size()
        );
    }

}
