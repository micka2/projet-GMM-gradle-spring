package fr.imie.gmm.repository;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Homework;

public interface HomeworkRepo extends CrudRepository<Homework, Long> {

	Homework findByTitle(String title);
}
