package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Promotion;


@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Long>{

	Promotion findByName(String promotionName);
	List<Promotion> findAll();

}
