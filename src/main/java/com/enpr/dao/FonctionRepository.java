package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Fonction;

@Repository
public interface FonctionRepository  extends CrudRepository<Fonction, Long>{
	
}

