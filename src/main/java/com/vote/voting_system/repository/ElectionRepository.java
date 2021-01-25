package com.vote.voting_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.voting_system.Model.Election;

public interface ElectionRepository extends JpaRepository<Election, Integer> {

}
