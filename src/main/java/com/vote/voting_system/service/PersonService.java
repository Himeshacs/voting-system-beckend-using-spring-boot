package com.vote.voting_system.service;



import java.util.List;

import com.vote.voting_system.Model.Person;

public interface PersonService {

	public Person save(Person person);
	public List<Person> findAll();
	public Person delete(int p_id);
}
