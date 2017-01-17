package fr.imie.gmm.repository;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Archive;

public interface ArchiveRepo extends CrudRepository<Archive, Long> {

	Archive findByTitle(String title);
}
