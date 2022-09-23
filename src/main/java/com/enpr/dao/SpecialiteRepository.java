package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Specialite;

@Repository
public interface SpecialiteRepository extends CrudRepository<Specialite, Long>{
	
}

