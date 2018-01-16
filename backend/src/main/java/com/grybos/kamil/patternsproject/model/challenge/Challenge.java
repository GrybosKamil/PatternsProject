package com.grybos.kamil.patternsproject.model.challenge;

import com.grybos.kamil.patternsproject.model.money.Money;
import com.grybos.kamil.patternsproject.model.user.Member;
import com.grybos.kamil.patternsproject.model.user.Organizer;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Organizer owner;

    private String name;

    private String description;

//    @ManyToOne
//    private ChallengeCategory category;

    //    @LazyCollection(LazyCollectionOption.FALSE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    private List<Money> rewards;

    private Integer memberLimit;

    //    @LazyCollection(LazyCollectionOption.TRUE)
//    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    private List<Member> participants;


    public Organizer getOwner() {
        return owner;
    }

    public void setOwner(Organizer owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public ChallengeCategory getCategory() {
//        return category;
//    }
//
//    public void setCategory(ChallengeCategory category) {
//        this.category = category;
//    }

    public List<Money> getRewards() {
        return rewards;
    }

    public void setRewards(List<Money> rewards) {
        this.rewards = rewards;
    }

    public Integer getMemberLimit() {
        return memberLimit;
    }

    public void setMemberLimit(Integer memberLimit) {
        this.memberLimit = memberLimit;
    }

    public List<Member> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Member> participants) {
        this.participants = participants;
    }

    public Challenge() {

    }

    public Challenge(Organizer owner,
//                     ChallengeCategory category,
                     String name, String description,
                     List<Money> rewards, Integer memberLimit) {
        this.owner = owner;
//        this.category = category;
        this.name = name;
        this.description = description;
        this.rewards = rewards;
        this.memberLimit = memberLimit;
        participants = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (; i < getRewards().size() - 1; i++) {
            stringBuilder
                    .append("{").append(i).append("}->")
                    .append(rewards.get(i).toString())
                    .append(", ");
        }
        stringBuilder
                .append("{").append(i).append("}->")
                .append(rewards.get(i));

        String reward = stringBuilder.toString();

        return String.format(
                "Challenge[" +
                        "id=%d, " +
                        "owner=[%s], " +
//                        "category=[%s], " +
                        "name='%s', " +
                        "description='%s', " +
                        "reward=[%s], " +
                        "memberLimit=[%s]," +
                        "participants=[%d]" +
                        "]",
                getId(), getOwner(),
//                getCategory(),
                getName(), getDescription(),
                reward, getMemberLimit(), getParticipants().size());
    }
}
