package br.com.cosati.iattend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cosati.iattend.domain.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {

	@Transactional(readOnly = true)
	public List<Province> findAllByOrderByName();
	
}
