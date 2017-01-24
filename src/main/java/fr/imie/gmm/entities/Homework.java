package fr.imie.gmm.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.imie.gmm.entities.base.EntityBase;



@Entity
@Inheritance
@Table(name="Homework")
public class Homework extends EntityBase {

//	@Column(name = "title", nullable = false, length = 100)
	private String title;

//	@Column(name = "date", nullable = false)
	private Date deposedAt;

//	@ManyToMany(targetEntity=Student.class, fetch=FetchType.EAGER)
	@ManyToOne
	private Student author;
	@ManyToOne
	private Subject subjectReference;
	
	
	///// Initialize getters and setters. /////
	
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
