package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Vaccin;

@Repository
public interface VaccinRepository  extends CrudRepository<Vaccin, Long> {

}

