package com.enpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Section;
import com.enpr.model.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {

	@Query("SELECT s FROM Session s WHERE s.etatSession = ?1 ")
	List<Session> findAllActiveSession(String etat);

}
