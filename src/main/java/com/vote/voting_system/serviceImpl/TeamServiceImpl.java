package com.vote.voting_system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.voting_system.Model.Team;
import com.vote.voting_system.repository.TeamRepository;
import com.vote.voting_system.service.TeamService;

@Service("teamService_01")
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public List<Team> findByAll() {
		// TODO Auto-generated method stub
		return teamRepository.findAll();
	}

}
