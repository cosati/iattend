package br.com.cosati.iattend.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cosati.iattend.domain.Session;
import br.com.cosati.iattend.domain.User;
import br.com.cosati.iattend.dto.SessionDTO;
import br.com.cosati.iattend.services.SessionService;
import br.com.cosati.iattend.services.UserService;
import br.com.cosati.iattend.services.exceptions.ConversionFailedException;

@RestController
@RequestMapping(value = "/sessions")
public class SessionResource {

	@Autowired
	private SessionService service;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<SessionDTO> find(@PathVariable Integer id) {
		Session obj = service.find(id);
		SessionDTO objDto = new SessionDTO(obj);
		return ResponseEntity.ok().body(objDto);
	}

	@RequestMapping(value = "/dates/", method = RequestMethod.GET)
	public ResponseEntity<Page<SessionDTO>> findSessionsByDate(
			@RequestParam(value = "start", defaultValue = "") @DateTimeFormat(pattern = "yyyyMMdd") Date start,
			@RequestParam(value = "end", defaultValue = "", required=false) @DateTimeFormat(pattern = "yyyyMMdd") Date end,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "date") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) throws ConversionFailedException {
		//TODO ConversionFailedException
		Page<Session> list = service.findByDateBetween(start, end, page, linesPerPage, orderBy, direction);
		Page<SessionDTO> listDto = list.map(obj -> new SessionDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<SessionDTO>> findPage(
			@RequestParam(value = "user_id", defaultValue = "") Integer user_id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "date") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		User user = userService.findById(user_id).get();
		Page<Session> list = service.searchSession(user, page, linesPerPage, orderBy, direction);
		Page<SessionDTO> listDto = list.map(obj -> new SessionDTO(obj));
		return ResponseEntity.ok().body(listDto);

	}

}
