package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Storage;

@Repository
public interface StorageRepository extends CrudRepository<Storage, Long> {

}
