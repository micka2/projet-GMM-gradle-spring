package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

	Teacher findByLogin (String login);
	Teacher findByLastname (List teachers);
}
