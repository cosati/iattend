package br.com.cosati.iattend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cosati.iattend.domain.Dojo;

@Repository
public interface DojoRepository extends JpaRepository<Dojo, Integer> {

	@Transactional(readOnly = true)
	public List<Dojo> findAll();
	
}
