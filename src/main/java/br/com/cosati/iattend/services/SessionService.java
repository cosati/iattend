package br.com.cosati.iattend.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.cosati.iattend.domain.Session;
import br.com.cosati.iattend.domain.User;
import br.com.cosati.iattend.repositories.SessionRepository;


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
	
	public Page<Session> searchInterval(Date start, Date end, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAllByDateBetween(start, end, pageRequest);
	}
	
}
