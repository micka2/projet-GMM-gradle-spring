package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Archive;

public interface ArchiveRepository extends CrudRepository<Archive, Long> {

	Archive findByTitle(String title);
}
