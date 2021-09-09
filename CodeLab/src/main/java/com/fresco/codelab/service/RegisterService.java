package com.fresco.codelab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fresco.codelab.model.CodeLabUser;
import com.fresco.codelab.repo.CodeLabRepoVersionRepository;
import com.fresco.codelab.repo.CodeLabUserRepository;



@Service
public class RegisterService {
	
	@Autowired
	CodeLabUserRepository codeLabUserRepository;
	/*@Autowired
	CodeLabUser codeLabUser;*/
	
	public Long registerUser(String fullname, String username, String password) {
		CodeLabUser codeLabUser = new CodeLabUser();
		codeLabUser.setFullname(fullname);
		codeLabUser.setUsername(username);
		codeLabUser.setPassword(password);	
		codeLabUser  =codeLabUserRepository.save(codeLabUser);
		return codeLabUser.getUserAutoGenId();
	}

}
