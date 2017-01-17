package fr.imie.gmm.repository;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {

	User findByLogin(String login);
}
