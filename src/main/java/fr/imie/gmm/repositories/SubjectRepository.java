package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long>{

	
	Subject findByTitle(String title);
	List<Subject> findAll();
}
