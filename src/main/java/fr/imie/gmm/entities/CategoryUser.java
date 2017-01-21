package fr.imie.gmm.entities;

import javax.persistence.Column;
import javax.persistence.Inheritance;


import fr.imie.gmm.entities.base.EntityBase;


@Inheritance
public class CategoryUser extends EntityBase {
	
	@Column
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
