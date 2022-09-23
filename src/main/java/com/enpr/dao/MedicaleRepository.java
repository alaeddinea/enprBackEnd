package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Medicale;


@Repository
public interface MedicaleRepository extends CrudRepository<Medicale, Long> {

}

