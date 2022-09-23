package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Salle;
@Repository
public interface SalleRepository extends  CrudRepository<Salle, Long> {
}
