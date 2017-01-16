package fr.imie.gmm.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Homework {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "title", nullable = false, length = 100)
	private String title;

	@Column(name = "date", nullable = false)
	private Date deposedAt;

	private Student author;
	private Subject subjectReference;
	
	
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
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the deposedAt
	 */
	public Date getDeposedAt() {
		return deposedAt;
	}
	/**
	 * @param deposedAt the deposedAt to set
	 */
	public void setDeposedAt(Date deposedAt) {
		this.deposedAt = deposedAt;
	}
	/**
	 * @return the author
	 */
	public Student getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(Student author) {
		this.author = author;
	}
	/**
	 * @return the subjectReference
	 */
	public Subject getSubjectReference() {
		return subjectReference;
	}
	/**
	 * @param subjectReference the subjectReference to set
	 */
	public void setSubjectReference(Subject subjectReference) {
		this.subjectReference = subjectReference;
	}
	
	

}