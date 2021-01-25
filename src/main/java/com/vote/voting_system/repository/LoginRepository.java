package com.vote.voting_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.voting_system.Model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	Optional<Login> findByUsernameAndPassword(String username,String password);
	
}
