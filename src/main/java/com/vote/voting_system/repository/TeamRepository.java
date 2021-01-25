package com.vote.voting_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.voting_system.Model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
