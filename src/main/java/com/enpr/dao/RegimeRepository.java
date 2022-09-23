package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Regime;
@Repository
public interface RegimeRepository extends  CrudRepository<Regime, Long> {
}

