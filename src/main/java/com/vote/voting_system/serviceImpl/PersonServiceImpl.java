package com.vote.voting_system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vote.voting_system.Model.Person;
import com.vote.voting_system.repository.PersonRepository;
import com.vote.voting_system.service.PersonService;

@Service("personService_01")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	
	
	@Override
	public Person save(Person person) {
				Person p=personRepository.save(person);
				
		return p;
	}


	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}


	@Override
	public Person delete(int p_id) {
		// TODO Auto-generated method stub
		Person entity=new Person();
		entity.setId(p_id);
		personRepository.delete(entity);
		
		return entity;
	}

}
