package br.com.cosati.iattend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cosati.iattend.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	@Transactional(readOnly = true)
	public List<City> findAll();
	
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM City obj WHERE obj.province.id = :provinceId ORDER BY obj.name")
	public List<City> findCities(@Param("provinceId") Integer province_id);
	
}
