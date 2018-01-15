package com.grybos.kamil.patternsproject.repository;

import com.grybos.kamil.patternsproject.model.user.Organizer;
import org.springframework.data.repository.CrudRepository;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {
    Organizer findByName(String name);

    Organizer findByUsername(String username);
}