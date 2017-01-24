package fr.imie.gmm.repositories;

import java.io.File;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Homework;



public interface HomeworkRepository extends CrudRepository<Homework, Long> {

	Homework findByTitle(String title);
	
	<S extends Homework> S save(File serverFile);
	
	//Homework delete(File serverFile);
	
	
	
}
