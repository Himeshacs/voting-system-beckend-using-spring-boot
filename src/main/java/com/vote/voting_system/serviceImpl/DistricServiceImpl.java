package com.vote.voting_system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.voting_system.Model.District;
import com.vote.voting_system.repository.DistricRepository;
import com.vote.voting_system.service.DistricService;

@Service("districService_01")
public class DistricServiceImpl implements DistricService {
	
	@Autowired
	DistricRepository districRepository;
	
	
	@Override
	public List<District> findByAll() {
		// TODO Auto-generated method stub
		return districRepository.findAll();
	}

}
