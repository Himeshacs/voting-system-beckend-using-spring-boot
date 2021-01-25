package com.vote.voting_system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.Team;
import com.vote.voting_system.repository.PoliticionRepository;
import com.vote.voting_system.service.PoliticionService;

@Service("politicionService_01")
public class PoliticionServiceImpl implements PoliticionService {

	@Autowired
	PoliticionRepository politicionRepository;
	
	@Override
	public Politicion save(Politicion politicion) {
		
		return politicionRepository.save(politicion);
	}

	@Override
	public Politicion delete(Politicion politicion) {
		// TODO Auto-generated method stub
		politicionRepository.delete(politicion);
		return politicion;
	}

	@Override
	public List<Politicion> findAll() {
		// TODO Auto-generated method stub
		return politicionRepository.findAll();
	}

	@Override
	public List<Politicion> findByTeam(Team team) {
		// TODO Auto-generated method stub
		return politicionRepository.findByTeam(team);
	}

	

}
