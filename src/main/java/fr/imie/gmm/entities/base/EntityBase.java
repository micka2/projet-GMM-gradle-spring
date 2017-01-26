package fr.imie.gmm.entities.base;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

public abstract class EntityBase{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	public EntityBase() {
		
	}
	
	public EntityBase(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
