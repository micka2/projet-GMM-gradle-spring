package fr.imie.gmm.entities;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Teacher")
public class Teacher extends User {

	
	
	@ManyToMany
	private List<Subject> subjects;
	
	@ManyToMany
	private List<Homework> homeworks;
	
	@ManyToMany
	private List<Grade> promotion;
	
	
//******************************************************************************************************************
    // constructor
	
//	public Teacher() {
//		
//	}
	public Teacher(String firstname, String lastname, String login, 
			  String password,String email, int categoryId) {
    	super(firstname, lastname, login, password,email, 1);
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
	public List<Grade> getPromotion() {
		return promotion;
	}
	/**
	 * @param promotion the promotion to set
	 */
	public void setPromotion(List<Grade> promotion) {
		this.promotion = promotion;
	}
    
	
//*****************************************************************************************************************	

}
