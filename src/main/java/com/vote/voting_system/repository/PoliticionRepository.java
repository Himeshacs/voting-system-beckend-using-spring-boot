package com.vote.voting_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.Team;

public interface PoliticionRepository extends JpaRepository<Politicion, Integer> {
public List<Politicion> findByTeam(Team team);
	
}
