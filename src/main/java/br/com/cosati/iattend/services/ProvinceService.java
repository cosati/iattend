package br.com.cosati.iattend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cosati.iattend.domain.Province;
import br.com.cosati.iattend.repositories.ProvinceRepository;

@Service
public class ProvinceService {

	@Autowired
	private ProvinceRepository repo;
	
	public List<Province> findAll() {
		return repo.findAllByOrderByName();
	}
	
}
