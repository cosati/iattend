package br.com.cosati.iattend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cosati.iattend.domain.City;
import br.com.cosati.iattend.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public List<City> findAll() {
		return cityRepository.findAll();
	}
	
	public List<City> findByProvince(Integer id) {
		return cityRepository.findCities(id);
	}
}
