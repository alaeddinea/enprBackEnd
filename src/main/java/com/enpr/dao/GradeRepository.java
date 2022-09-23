package com.enpr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Grade;



@Repository
public interface GradeRepository extends CrudRepository<Grade, Long> {

}
