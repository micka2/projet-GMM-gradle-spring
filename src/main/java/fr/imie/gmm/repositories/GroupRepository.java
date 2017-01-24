package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long>{

}
