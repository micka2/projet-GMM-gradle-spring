package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>{

}
