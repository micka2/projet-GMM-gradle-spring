package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long>{

}
