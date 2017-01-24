package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Archive;

@Repository
public interface ArchiveRepository extends CrudRepository<Archive, Long> {

//	Archive findByTitle(String title);
}
