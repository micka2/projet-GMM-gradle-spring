package fr.imie.gmm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long>{

}
