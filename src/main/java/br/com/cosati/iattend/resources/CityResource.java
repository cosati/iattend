package br.com.cosati.iattend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cosati.iattend.domain.City;
import br.com.cosati.iattend.services.CityService;

@RestController
@RequestMapping(value="/city")
public class CityResource {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<City>> findAll() {		
		List<City> list = cityService.findAll();
		return ResponseEntity.ok().body(list);				
	}
	
}
