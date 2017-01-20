package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.imie.gmm.entities.Promotion;


public interface PromotionRepository extends CrudRepository<Promotion, Long>{

	Promotion findById(Long promo_id);

}
