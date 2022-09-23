package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Etatcivil;


@Repository
public interface EtatcivilRepository extends CrudRepository<Etatcivil, Long>{
	
}

