package fr.imie.gmm.repository;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Notification;

public interface NotificationRepo extends CrudRepository<Notification, Long>{

}
