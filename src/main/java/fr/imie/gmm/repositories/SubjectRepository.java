package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{
	  
	Subject findByTitle(String title);
	List<Subject> findAll();

}
