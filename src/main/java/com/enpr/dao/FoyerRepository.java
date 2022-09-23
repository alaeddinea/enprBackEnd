package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Foyer;
@Repository
public interface FoyerRepository extends  CrudRepository<Foyer, Long> {
}
