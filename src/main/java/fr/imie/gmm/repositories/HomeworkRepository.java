package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Homework;

public interface HomeworkRepository extends CrudRepository<Homework, Long> {

	Homework findByTitle(String title);
}
