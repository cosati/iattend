package br.com.cosati.iattend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cosati.iattend.domain.User;
import br.com.cosati.iattend.domain.enums.Graduation;
import br.com.cosati.iattend.domain.enums.Profile;
import br.com.cosati.iattend.dto.UserNewDTO;
import br.com.cosati.iattend.repositories.UserRepository;
import br.com.cosati.iattend.security.UserSS;
import br.com.cosati.iattend.services.exceptions.AuthorizationException;
import br.com.cosati.iattend.services.exceptions.DataIntegrityException;
import br.com.cosati.iattend.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UserRepository userRepository;
	
	public User findById(Integer id) {
		UserSS user = authenticated();
		if (user == null || !user.hasHole(Profile.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		User u = userRepository.findById(id).get();
		if (u == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + User.class.getName());
		}
		return u;
	}
	
	@Transactional
	public User insert(User obj) {
		obj.setId(null);
		obj = userRepository.save(obj);
		//TODO Save adderess
		return obj;
	}
	
	public User update(User obj) {
		User newObj =  findById(obj.getId());
		updateData(newObj, obj);
		return userRepository.save(newObj); 
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			userRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas.");
		}
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserNewDTO dto) {
		User user = new User(null, dto.getName(), dto.getLastName(), dto.getEmail(), dto.getCpf(), Graduation.toEnum(dto.getGraduation()), pe.encode(dto.getPassword()));
		return user;		
	}
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
