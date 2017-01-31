package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Homework;



public interface HomeworkRepository extends CrudRepository<Homework, Long> {

	Homework findByTitle(String title);
	
	<S extends Homework> S save(S entity);
	
	void delete(Long id);
	
	List<Homework> findAll();
    

	
	
	
}
