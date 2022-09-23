package com.enpr.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.enpr.model.ConsultationEleve;

public interface ConsultationEleveRepository extends  CrudRepository<ConsultationEleve, Long> { 
	@Query("SELECT s FROM ConsultationEleve s WHERE s.eleve.id = ?1 ")
	List<ConsultationEleve> findAllSonByMother(Long id);
}

