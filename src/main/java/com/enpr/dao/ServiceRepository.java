package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Service;

@Repository
public interface ServiceRepository extends  CrudRepository<Service, Long> {
}

