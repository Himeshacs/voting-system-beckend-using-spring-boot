package com.vote.voting_system.service;

import java.util.List;

import com.vote.voting_system.Model.Role;
import com.vote.voting_system.Model.RoleHasActivite;



public interface RolehasActivitiesService {
	
	public List <RoleHasActivite> findbyroleid(Role role_id);
}
