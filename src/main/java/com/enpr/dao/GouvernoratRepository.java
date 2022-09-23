package com.enpr.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Delegation;
import com.enpr.model.Gouvernorat;

@Repository
public interface GouvernoratRepository extends CrudRepository<Gouvernorat, Long>{
	
}
