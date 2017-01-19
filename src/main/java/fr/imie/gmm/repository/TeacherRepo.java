package fr.imie.gmm.repository;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Teacher;

public interface TeacherRepo extends CrudRepository<Teacher, Long> {

}
