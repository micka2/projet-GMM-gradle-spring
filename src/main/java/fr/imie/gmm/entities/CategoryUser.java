package fr.imie.gmm.entities;

import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;

import fr.imie.gmm.entities.base.EntityBase;


@Inheritance
public class CategoryUser extends EntityBase {
	
	@JoinColumn(name="category")
	private String category;

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
