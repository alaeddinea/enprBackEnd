package com.enpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Company;
import com.enpr.model.Section;

@Repository
public interface SectionRepository  extends CrudRepository<Section, Long> {
	@Query("SELECT s FROM Section s WHERE s.company.id = ?1 ")
	List<Section> findAllSonByMother(Long id);

}
