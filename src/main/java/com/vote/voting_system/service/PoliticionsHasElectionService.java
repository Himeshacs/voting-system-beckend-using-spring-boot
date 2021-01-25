package com.vote.voting_system.service;

import java.util.List;

import com.vote.voting_system.Model.District;
import com.vote.voting_system.Model.PoliticionsHasElection;
import com.vote.voting_system.Model.Team;

public interface PoliticionsHasElectionService {

	public PoliticionsHasElection save(PoliticionsHasElection politicionsHasElection);
	public List<PoliticionsHasElection> findByDistric(District district);
	
}
