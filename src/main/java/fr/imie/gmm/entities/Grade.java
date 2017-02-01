package fr.imie.gmm.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.imie.gmm.entities.base.EntityBase;

@Entity
@Table(name = "Grade")
public class Grade extends EntityBase {

	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	@Column(nullable = false, length = 20, name = "promotionName")
	private String name;
	@Column
	private Integer year;
	@OneToMany
	private List<Subject> subjects;

	/**
	 * constructor
	 */
	public Grade(String Name) {
		this.name = Name;
	}

	public Grade(String Name, Integer Year) {
		this.name = Name;
		this.year = Year;
	}

	// empty constructor

	public Grade() {

	}

	/**
	 * Getters and Setters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
