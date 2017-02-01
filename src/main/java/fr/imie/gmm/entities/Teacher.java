package fr.imie.gmm.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
@PrimaryKeyJoinColumn(name = "id")
public class Teacher extends User {

	@ManyToMany
	private List<Subject> subjects;

	@ManyToMany
	private List<Homework> homeworks;

	@ManyToMany
	private List<Grade> grades;

	// ******************************************************************************************************************
	// redefinition du(des) constructeur(s) de la classe Teacher

	public Teacher() {
		super();
	}

	/**
	 * constructor for creating a Teacher entity with parameters
	 * 
	 * @param firstname
	 *            : String
	 * @param lastname
	 *            : String
	 * @param login
	 *            : String
	 * @param password
	 *            : String
	 * @param category
	 *            : int
	 */
	public Teacher(String firstname, String lastname, String login, String password, int category) {
		super(firstname, lastname, login, password, password, 2);
	}

	/**
	 * empty constructor for creating a Teacher entity
	 * 
	 */
	public Teacher(User user) {
		super(user.getFirstname(), user.getLastname(), user.getLogin(), user.getPassword(), user.getPassword(), 2);
	}

	// *****************************************************************************************************************

	/**
	 * @return the subjects
	 */
	public List<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects
	 *            the subjects to set
	 */
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	/**
	 * @return the homeworks
	 */
	public List<Homework> getHomeworks() {
		return homeworks;
	}

	/**
	 * @param homeworks
	 *            the homeworks to set
	 */
	public void setHomeworks(List<Homework> homeworks) {
		this.homeworks = homeworks;
	}

	/**
	 * @return the promotion
	 */
	public List<Grade> getGrades() {
		return grades;
	}

	/**
	 * @param promotion
	 *            the promotion to set
	 */
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	// *****************************************************************************************************************

}
