package com.grybos.kamil.patternsproject.repository;

import com.grybos.kamil.patternsproject.model.challenge.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Transactional
    Challenge findByName(String name);

    @Transactional
    List<Challenge> findByOwner(String username);

    //    @Transactional
    //    List<Challenge> findByCategory(String category);

    @Modifying
    @Transactional
    Challenge save(Challenge challenge);

//    @Modifying
//    @Transactional
//    @Query("UPDATE Member m SET m.name = :name WHERE m.username = :username")
//    int updateName(@Param("username") String username, @Param("name") String name);

}