package fr.imie.gmm.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;


@Entity
public class Teacher extends User {

	
	@Column
	@ManyToMany(targetEntity=Subject.class, fetch=FetchType.LAZY)
	private List<Subject> subjects;
	@Column
	@ManyToMany(targetEntity=Homework.class, fetch=FetchType.LAZY)
	private List<Homework> homeworks;
	@Column
	@ManyToMany(mappedBy="name")
	private List<Promotion> promotion;
	
	
//******************************************************************************************************************
    // constructor
	
//	public Teacher() {
//		
//	}
	public Teacher(String firstname,String lastname,int categoryId,String login,String password) {
    	super(firstname, lastname, 1, login, password, password);
    }
    public Teacher(){
    	
    }
    
  //*****************************************************************************************************************

	/**
	 * @return the subjects
	 */
	public List<Subject> getSubjects() {
		return subjects;
	}
	/**
	 * @param subjects the subjects to set
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
	 * @param homeworks the homeworks to set
	 */
	public void setHomeworks(List<Homework> homeworks) {
		this.homeworks = homeworks;
	}
	/**
	 * @return the promotion
	 */
	public List<Promotion> getPromotion() {
		return promotion;
	}
	/**
	 * @param promotion the promotion to set
	 */
	public void setPromotion(List<Promotion> promotion) {
		this.promotion = promotion;
	}
    
	
//*****************************************************************************************************************	

}
