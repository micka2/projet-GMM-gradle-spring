package fr.imie.gmm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.imie.gmm.entities.Promotion;

<<<<<<< HEAD
=======

>>>>>>> 5ce212d846a37eaae754a563d30443816ce97501
@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Long>{

	Promotion findByName(String promotionName);
	List<Promotion> findAll();

}
