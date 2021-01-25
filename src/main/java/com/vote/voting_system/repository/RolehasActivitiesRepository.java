package com.vote.voting_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.voting_system.Model.Role;
import com.vote.voting_system.Model.RoleHasActivite;

public interface RolehasActivitiesRepository extends JpaRepository<RoleHasActivite, Integer> {

	public List<RoleHasActivite> findByRole(Role role);
	
}
