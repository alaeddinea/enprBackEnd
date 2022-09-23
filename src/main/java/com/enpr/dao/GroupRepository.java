package com.enpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enpr.model.Delegation;
import com.enpr.model.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
	@Query("SELECT s FROM Group s WHERE s.session.id = ?1 ")
	List<Group> findAllSonByMother(Long id);
}
