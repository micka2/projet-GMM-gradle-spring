package fr.imie.gmm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Promotion;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Long>{

	Promotion findById(Long promo_id);

}
