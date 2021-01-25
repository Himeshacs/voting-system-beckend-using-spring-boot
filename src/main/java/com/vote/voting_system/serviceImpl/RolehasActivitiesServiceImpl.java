package com.vote.voting_system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.voting_system.Model.Role;
import com.vote.voting_system.Model.RoleHasActivite;
import com.vote.voting_system.repository.RolehasActivitiesRepository;
import com.vote.voting_system.service.RolehasActivitiesService;

@Service("rolehasActivitiesService_01")
public class RolehasActivitiesServiceImpl implements RolehasActivitiesService{

	@Autowired
	RolehasActivitiesRepository rolehasActivitiesRepository;
	
	@Override
	public List<RoleHasActivite> findbyroleid(Role role_id) {
		// TODO Auto-generated method stub
		return rolehasActivitiesRepository.findAll();
	}

}
