package fr.imie.gmm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Subject;

public interface SubjectRepo extends CrudRepository<Subject, Long>{

	
	Subject findByTitle(String title);
	List<Subject> findAll();
}
