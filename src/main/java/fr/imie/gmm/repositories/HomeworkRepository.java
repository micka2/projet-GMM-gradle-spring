package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Homework;

@Repository
public interface HomeworkRepository extends CrudRepository<Homework, Long> {

	Homework findByTitle(String title);
}
