package fr.imie.gmm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Archive {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
//	private Subject subjectReference;
//	private Homework homeworkReference;
//	private Storage urlReference;
	
	///// Initialize getters and setters. /////
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
