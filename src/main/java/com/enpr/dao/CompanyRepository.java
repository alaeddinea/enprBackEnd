package com.enpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Company;
import com.enpr.model.Group;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
	@Query("SELECT s FROM Company s WHERE s.group.id = ?1 ")
	List<Company> findAllSonByMother(Long id);
}
