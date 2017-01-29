package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Student;
import fr.imie.gmm.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();
	User findByLogin(String login);

	User findOne(Long id);
	
}
