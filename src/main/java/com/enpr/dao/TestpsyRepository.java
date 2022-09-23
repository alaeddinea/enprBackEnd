package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Testpsy;


@Repository
public interface TestpsyRepository extends  CrudRepository<Testpsy, Long> {
}

