package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {

	User findByLogin(String login);
}
