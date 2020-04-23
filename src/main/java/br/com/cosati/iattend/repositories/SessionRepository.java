package br.com.cosati.iattend.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cosati.iattend.domain.Session;
import br.com.cosati.iattend.domain.User;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

	@Transactional(readOnly = true)
	public List<Session> findAllByOrderByDate();
	
	@Transactional(readOnly = true)
	//@Query("SELECT DINSTINCT obj FROM Session obj INNER JOIN obj.users u WHERE u = :user")
	Page<Session> findDistinctByUsers(@Param("user") User user, Pageable pageRequest);
	
	@Transactional(readOnly = true)
	Page<Session> findAllByDateBetween(Date d1, Date d2, Pageable pageRequest);
	
}
