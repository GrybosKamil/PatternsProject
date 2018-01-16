package com.grybos.kamil.patternsproject.model.challenge;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ChallengeCategory {

    private String name;

    public ChallengeCategory() {

    }

    public ChallengeCategory(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = hash * 31 + name.charAt(i);
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChallengeCategory) {
            ChallengeCategory other = (ChallengeCategory) obj;
            return equals(other);
        }
        return false;
    }

    public boolean equals(ChallengeCategory obj) {
        return Objects.equals(this.getName(), obj.getName());
    }

    @Override
    public String toString() {
        return String.format(
                "ChallengeCategory[" +
                        "name='%s' " +
                        "]",
                getName());
    }

    public String getName() {
        return name;
    }
}
