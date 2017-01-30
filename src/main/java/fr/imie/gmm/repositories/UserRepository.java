package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Student;
import fr.imie.gmm.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

<<<<<<< HEAD
	User findByCategoryId(int categoryId);
=======
	List<User> findAll();
>>>>>>> master
	User findByLogin(String login);

	User findOne(Long id);
	
}
