package com.vote.voting_system.service;

import java.util.Optional;

import com.vote.voting_system.Model.Login;

public interface LoginService {

	public Optional<Login> findByUsernameAndPassword(String username,String password);
	public Login save(Login login);
}
