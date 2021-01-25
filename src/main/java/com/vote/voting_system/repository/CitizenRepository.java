package com.vote.voting_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vote.voting_system.Model.Citizen;
import com.vote.voting_system.Model.Person;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

	Optional<Citizen> findByPerson(Person person);
	Optional<Citizen> findByIdAndCode(int id,String code);
//	@Modifying
//	@Query("update citizen c set c.status = :status")
//	int setStatusForCitizen(@Param("status") Integer status);
}
