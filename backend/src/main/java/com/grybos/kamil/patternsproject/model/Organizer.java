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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Organizer[id=%d, username='%s', name='%s' description='%s'",
                getId(), getUsername(), getName(), getDescription());
    }
}
