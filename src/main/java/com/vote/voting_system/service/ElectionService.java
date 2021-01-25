package com.vote.voting_system.service;

import java.util.List;

import com.vote.voting_system.Model.Election;

public interface ElectionService {

	public Election save(Election election);
	public List<Election> findAll();
	
}
