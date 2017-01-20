package fr.imie.gmm.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Teacher extends User {

	
	@Column
	@ManyToMany(targetEntity=Subject.class, fetch=FetchType.LAZY)
	private List<Subject> subjects;
	@Column
	@ManyToMany(targetEntity=Homework.class, fetch=FetchType.LAZY)
	private List<Homework> homeworks;
	@Column
	@ManyToMany(targetEntity=Promotion.class, fetch=FetchType.LAZY)
	private List<Integer>promotion;
	
	
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
	
	public List<Subject> getSujets() {
		return subjects;
	}
	public void setSujets(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public List<Homework> getHomeworks() {
		return homeworks;
	}
	public void setHomeworks(List<Homework> homeworks) {
		this.homeworks = homeworks;
	}
	public List<Integer> getPromotion() {
		return promotion;
	}
	public void setPromotion(List<Integer> promotion) {
		this.promotion = promotion;
	}
	
//*****************************************************************************************************************	

}
