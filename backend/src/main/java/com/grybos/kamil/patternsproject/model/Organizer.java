package com.grybos.kamil.patternsproject.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Organizer extends Member {

    @Column
    private String description;

    public Organizer() {
    }

    public Organizer(String username, String name) {
        super(username, name);
    }

    public Organizer(String username, String name, Wallet wallet) {
        super(username, name, wallet);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Organizer[" +
                        "member=[%s], " +
                        "description='%s'" +
                        "]",
                super.toString(), getDescription());
    }
}
