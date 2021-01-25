package com.vote.voting_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.voting_system.Model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
