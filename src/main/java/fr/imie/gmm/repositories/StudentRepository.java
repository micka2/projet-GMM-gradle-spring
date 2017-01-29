package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Homework;
import fr.imie.gmm.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	Student findByFirstname(String firstname);
	

		
}
