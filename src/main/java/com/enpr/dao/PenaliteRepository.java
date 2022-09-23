package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Penalite;


@Repository
public interface PenaliteRepository extends CrudRepository<Penalite, Long> {

}
