package com.vote.voting_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.voting_system.Model.District;
import com.vote.voting_system.Model.PoliticionsHasElection;

public interface PoliticionsHasElectionRepository extends JpaRepository<PoliticionsHasElection, Integer> {

	public List<PoliticionsHasElection> findByDistrict(District district);
}
