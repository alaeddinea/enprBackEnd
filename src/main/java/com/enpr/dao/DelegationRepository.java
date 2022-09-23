package com.enpr.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Delegation;


@Repository
public interface DelegationRepository  extends CrudRepository<Delegation, Long>{
	@Query("SELECT s FROM Delegation s WHERE s.gouvernorat.id = ?1 ")
	List<Delegation> findAllSonByMother(Long id);
}
