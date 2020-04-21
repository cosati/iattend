package br.com.cosati.iattend.services;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cosati.iattend.domain.City;
import br.com.cosati.iattend.domain.Province;
import br.com.cosati.iattend.domain.Session;
import br.com.cosati.iattend.domain.User;
import br.com.cosati.iattend.domain.enums.Graduation;
import br.com.cosati.iattend.repositories.CityRepository;
import br.com.cosati.iattend.repositories.ProvinceRepository;
import br.com.cosati.iattend.repositories.SessionRepository;
import br.com.cosati.iattend.repositories.UserRepository;

@Service
public class DBService {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
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
		
		User u1 = new User(null, "Alexandre", "Cosati", "cosati@hotmail.com", "74398634029", Graduation.BLACK, "123");
		User u2 = new User(null, "Ricardo", "Soares", "rbushido@hotmail.com", "74398634029", Graduation.BLACK, "123");
		User u3 = new User(null, "Layon", "Onofre", "layon@hotmail.com", "74398634029", Graduation.BROWN, "123");
		
		Session s1 = new Session(null, new Date(), 90, "Kata");
		Session s2 = new Session(null, new Date(), 120, "Kumite");
		Session s3 = new Session(null, new Date(), 90, "Kihon");
		Session s4 = new Session(null, new Date(), 60, "Kata");
		
		u1.getSessions().addAll(Arrays.asList(s1, s2, s4));
		u2.getSessions().addAll(Arrays.asList(s1, s2, s3, s4));
		u3.getSessions().addAll(Arrays.asList(s3, s4));
		
		s1.getUsers().addAll(Arrays.asList(u1, u2));
		s2.getUsers().addAll(Arrays.asList(u1, u2));
		s3.getUsers().addAll(Arrays.asList(u2, u3));
		s4.getUsers().addAll(Arrays.asList(u1, u2, u3));
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		sessionRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
		
	}
	
}
