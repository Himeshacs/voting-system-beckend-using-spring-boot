package com.vote.voting_system.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.voting_system.Model.Login;
import com.vote.voting_system.repository.LoginRepository;
import com.vote.voting_system.service.LoginService;

@Service("loginService_01")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public Optional<Login> findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return loginRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public Login save(Login login) {
		// TODO Auto-generated method stub
		return loginRepository.save(login);
	}

}
