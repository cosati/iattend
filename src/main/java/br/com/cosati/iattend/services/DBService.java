package br.com.cosati.iattend.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cosati.iattend.domain.City;
import br.com.cosati.iattend.domain.Province;
import br.com.cosati.iattend.repositories.CityRepository;
import br.com.cosati.iattend.repositories.ProvinceRepository;

@Service
public class DBService {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
	public void instantiateTestDatabase () throws ParseException  {
		
		Province p1 = new Province(null, "Paraná");
		Province p2 = new Province(null, "Santa Catarina");
		Province p3 = new Province(null, "São Paulo");
		Province p4 = new Province(null, "Rio Grande do Sul");
		
		City c1 = new City(null, "Ponta Grossa", p1);
		City c2 = new City(null, "Curitiba", p1);
		City c3 = new City(null, "São Paulo", p3);
		City c4 = new City(null, "Porto Alegre", p4);
		City c5 = new City(null, "Florianópolis", p2);
		
		p1.getCities().addAll(Arrays.asList(c1, c2));
		p2.getCities().addAll(Arrays.asList(c5));
		p3.getCities().addAll(Arrays.asList(c3));
		p4.getCities().addAll(Arrays.asList(c4));
		
		provinceRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		
	}
	
}
