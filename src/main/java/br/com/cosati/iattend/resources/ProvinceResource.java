package br.com.cosati.iattend.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cosati.iattend.domain.City;
import br.com.cosati.iattend.domain.Province;
import br.com.cosati.iattend.dto.CityDTO;
import br.com.cosati.iattend.dto.ProvinceDTO;
import br.com.cosati.iattend.services.CityService;
import br.com.cosati.iattend.services.ProvinceService;

@RestController
@RequestMapping(value="/province")
public class ProvinceResource {

	@Autowired
	private ProvinceService service;
	
	@Autowired CityService cityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProvinceDTO>> findAll() {		
		List<Province> list = service.findAll();
		List<ProvinceDTO> listDTO = list.stream().map(obj -> new ProvinceDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);				
	}
	
	@RequestMapping(value="/{id}/cities", method=RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> find(@PathVariable Integer id) {
		List<City> list = cityService.findByProvince(id);
		List<CityDTO> listDto = list.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
