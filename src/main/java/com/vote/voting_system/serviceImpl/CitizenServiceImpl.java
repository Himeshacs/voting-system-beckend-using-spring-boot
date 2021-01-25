package com.vote.voting_system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.voting_system.Model.Citizen;
import com.vote.voting_system.Model.Person;
import com.vote.voting_system.repository.CitizenRepository;
import com.vote.voting_system.service.CitizenService;

@Service("citizenService_01")
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	CitizenRepository citizenRepository;
	
	@Override
	public Citizen save(Citizen citizen) {
		// TODO Auto-generated method stub
		return citizenRepository.save(citizen);
	}

	@Override
	public Optional<Citizen> findById(Person person) {
		// TODO Auto-generated method stub
		return citizenRepository.findByPerson(person);
	}

	@Override
	public List<Citizen> findByAll() {
		// TODO Auto-generated method stub
		return citizenRepository.findAll();
	}

	@Override
	public Citizen delete(int c_id) {
		// TODO Auto-generated method stub
		Citizen entity=new Citizen();
		entity.setId(c_id);
		citizenRepository.delete(entity);
		return entity;
	}

	@Override
	public Optional<Citizen> findByIdAndCode(int id, String code) {
		// TODO Auto-generated method stub
		return citizenRepository.findByIdAndCode(id, code);
	}

}
