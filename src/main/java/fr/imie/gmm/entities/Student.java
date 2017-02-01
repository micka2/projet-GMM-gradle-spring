package fr.imie.gmm.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {

	@ManyToOne
	private WorkingGroup groupId;

	@ManyToOne
	private Grade gradeId;

	// ************************************************************************************************************
	// redefinition du(des) constructeur(s) de la classe Student

	public Student() {
		super();
	}

	/**
	 * constructor for creating a Student entity with parameters
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
	public Student(String firstname, String lastname, String login, String password, int category) {
		super(firstname, lastname, login, password, password, 2);
	}

	/**
	 * empty constructor for creating a Student entity
	 * 
	 */
	public Student(User user) {
		super(user.getFirstname(), user.getLastname(), user.getLogin(), user.getPassword(), user.getPassword(), 2);
	}

	// ************************************************************************************************************
	// getters et setters

	/**
	 * @return the groupId
	 */
	public WorkingGroup getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(WorkingGroup groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the promotionId
	 */
	public Grade getGradeId() {
		return gradeId;
	}

	/**
	 * @param promotionId
	 *            the promotionId to set
	 */
	public void setPromotionId(Grade gradeId) {
		this.gradeId = gradeId;
	}

	@Override
	public String toString() {
		return String.format("User[id=%d, username='%s'",

				this.login);
	}

	/**
	 * @param gradeId
	 *            the gradeId to set
	 */
	public void setGradeId(Grade gradeId) {
		this.gradeId = gradeId;
	}

}
