package fr.imie.gmm.repository;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Student;

public interface StudentRepo extends CrudRepository<Student, Long>{

}
