package br.com.cosati.iattend.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cosati.iattend.domain.City;
import br.com.cosati.iattend.repositories.CityRepository;

@Service
public class DBService {

	@Autowired
	private CityRepository cityRepository;
	
	public void instantiateTestDatabase () throws ParseException  {
		
		City c1 = new City(null, "Ponta Grossa");
		City c2 = new City(null, "Curitiba");
		City c3 = new City(null, "São Paulo");
		City c4 = new City(null, "Porto Alegre");
		City c5 = new City(null, "Florianópolis");
		
		cityRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		
	}
	
}
