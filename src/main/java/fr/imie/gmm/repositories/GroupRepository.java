package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long>{
	
	Group findByName(String groupName);
	List<Group> findAll();
}
