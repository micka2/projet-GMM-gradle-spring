package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.WorkingGroup;

@Repository
public interface WorkingGroupRepository extends CrudRepository<WorkingGroup, Long>{
	
	//WorkingGroup findByName(String groupName);
	List<WorkingGroup> findAll();
}
