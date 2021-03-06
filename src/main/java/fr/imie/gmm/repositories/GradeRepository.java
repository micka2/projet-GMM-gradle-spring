package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Grade;



public interface GradeRepository extends CrudRepository<Grade, Long>{

	Grade findByName(String Name);
	List<Grade> findAll();
	
	Grade findOne(Long id);

}
