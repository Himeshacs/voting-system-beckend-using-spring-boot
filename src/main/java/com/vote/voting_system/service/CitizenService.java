package com.vote.voting_system.service;

import java.util.List;
import java.util.Optional;

import com.vote.voting_system.Model.Citizen;
import com.vote.voting_system.Model.Person;

public interface CitizenService {

	public Citizen save(Citizen citizen);
	public Optional<Citizen> findById(Person person);
	public List<Citizen> findByAll();
	public Citizen delete(int c_id);
	public Optional<Citizen> findByIdAndCode(int id,String code);
}
