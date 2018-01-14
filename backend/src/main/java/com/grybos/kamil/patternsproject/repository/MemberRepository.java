package com.grybos.kamil.patternsproject.repository;

import com.grybos.kamil.patternsproject.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByName(String name);

    Member findByUsername(String username);
}