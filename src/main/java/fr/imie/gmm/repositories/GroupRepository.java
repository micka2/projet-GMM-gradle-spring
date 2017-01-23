package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Group;


public interface GroupRepository extends CrudRepository<Group, Long>{
	
	Group findByName(String groupName);
	List<Group> findAll();
}
