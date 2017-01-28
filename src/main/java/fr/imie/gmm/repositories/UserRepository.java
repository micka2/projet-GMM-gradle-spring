package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	
	User findByLogin(String login);


	
}
