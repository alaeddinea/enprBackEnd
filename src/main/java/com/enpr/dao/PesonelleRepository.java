package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Personelle;

@Repository
public interface PesonelleRepository extends CrudRepository<Personelle, Long> {

}

