package com.enpr.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.enpr.model.ImageModel;

public interface ImageRepository extends CrudRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
	//Optional<ImageModel> findByEleve(Eleve eleve);
	/*@Query("SELECT s FROM Section s WHERE s.company.id = ?1 ")
	List<Section> findAllSonByMother(Long id);*/
}