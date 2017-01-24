package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.WorkingGroup;


public interface WorkingGroupRepository extends CrudRepository<WorkingGroup, Long>{
	
	WorkingGroup findByName(String groupName);
	List<WorkingGroup> findAll();
}
