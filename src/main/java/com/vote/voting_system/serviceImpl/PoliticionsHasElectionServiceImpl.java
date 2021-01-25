package com.vote.voting_system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.voting_system.Model.District;
import com.vote.voting_system.Model.PoliticionsHasElection;
import com.vote.voting_system.repository.PoliticionsHasElectionRepository;
import com.vote.voting_system.service.PoliticionsHasElectionService;

@Service("politicionsHasElectionService_01")
public class PoliticionsHasElectionServiceImpl implements PoliticionsHasElectionService {

	@Autowired
	PoliticionsHasElectionRepository politicionsHasElectionRepository;
	
	@Override
	public PoliticionsHasElection save(PoliticionsHasElection politicionsHasElection) {
		// TODO Auto-generated method stub
		return politicionsHasElectionRepository.save(politicionsHasElection);
	}

	@Override
	public List<PoliticionsHasElection> findByDistric(District district) {
		// TODO Auto-generated method stub
		return politicionsHasElectionRepository.findByDistrict(district);
	}

}
