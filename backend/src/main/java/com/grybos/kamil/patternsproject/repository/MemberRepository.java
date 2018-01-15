package com.grybos.kamil.patternsproject.repository;

import com.grybos.kamil.patternsproject.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Transactional
    Member findByName(String name);

    @Modifying
    @Transactional
    Member save(Member member);

    @Transactional
    Member findByUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE Member m SET m.name = :name WHERE m.username = :username")
    int updateName(@Param("username") String username, @Param("name") String name);

}