package br.com.cosati.iattend.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.cosati.iattend.domain.Session;
import br.com.cosati.iattend.domain.User;
import br.com.cosati.iattend.dto.SessionDTO;
import br.com.cosati.iattend.repositories.SessionRepository;
import br.com.cosati.iattend.security.UserSS;


@Service
public class SessionService {

	@Autowired
	private SessionRepository repo;
	
	public Session find(Integer id) {
		Session obj = repo.findById(id).get();
		//TODO Not found Exception
		return obj;
	}
	
	public Page<Session> searchSession(User user, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findDistinctByUsers(user, pageRequest);
	}
	
	public Page<Session> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Page<Session> findByStartBetween(Date start, Date end, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		if (end != null) {
			return repo.findAllByStartBetween(start, end, pageRequest);
		} 
		return repo.findAllByStart(start, pageRequest);		
	}
	
	public Page<SessionDTO> findByDateGreaterThanEqual(Date date, Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		if (date == null) {
			date = new Date();
		}
		Page<Session> list = repo.findAllByEndGreaterThanEqualOrderByStart(date, pageRequest);		
		Page<SessionDTO> listDto = (user != null ? 
				list.map(obj -> new SessionDTO(obj, user.getId())) : list.map(obj -> new SessionDTO(obj)));		
		return listDto;
	}
	
}
