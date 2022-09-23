package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Administration;

@Repository
public interface AdministrationRepository extends  CrudRepository<Administration, Long> {
}
