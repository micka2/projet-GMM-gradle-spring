package fr.imie.gmm.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import fr.imie.gmm.entities.base.EntityBase;



@Entity
@Inheritance
public class Homework extends EntityBase {

	@Column(name = "title", nullable = false, length = 100)
	private String title;

	@Column(name = "date", nullable = false)
	private Date deposedAt;
	
	private byte[] data;

	@ManyToMany(targetEntity=Student.class, fetch=FetchType.EAGER)
	private Student author;
	@ManyToOne(targetEntity=Subject.class, fetch=FetchType.EAGER)
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
	/**
	 * @return the data
	 */
	public byte[] getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(byte[] data) {
		this.data = data;
	}
	
	

}
