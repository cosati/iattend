package br.com.cosati.iattend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cosati.iattend.domain.User;
import br.com.cosati.iattend.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findById(Integer id) {
		//return userRepository.getOne(id);
		return userRepository.findById(id);
	}
	
}
