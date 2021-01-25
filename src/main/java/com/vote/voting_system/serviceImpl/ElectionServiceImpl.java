package com.vote.voting_system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.voting_system.Model.Election;
import com.vote.voting_system.repository.ElectionRepository;
import com.vote.voting_system.service.ElectionService;

@Service("electionService_01")
public class ElectionServiceImpl implements ElectionService {

	@Autowired
	ElectionRepository electionRepository;
	
	@Override
	public Election save(Election election) {
		// TODO Auto-generated method stub
		return electionRepository.save(election);
	}

	@Override
	public List<Election> findAll() {
		// TODO Auto-generated method stub
		return electionRepository.findAll();
	}

}
