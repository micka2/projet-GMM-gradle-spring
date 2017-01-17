package fr.imie.gmm.repository;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Subject;

public interface SubjectRepo extends CrudRepository<Subject, Long>{

	
	Subject findByTitle(String title);
}
