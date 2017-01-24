package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Administrator;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long>{
	
}
