package fr.imie.gmm.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Teacher extends User {

	
	@Column
	private List<Subject> sujets;
	@Column
	private List<Homework> homeworks;
	@Column
	private List<Integer>promotion;
	
	
//******************************************************************************************************************
    // constructor
	
//	public Teacher() {
//		
//	}
	public Teacher(String firstname,String lastname,int categoryId,String login,String password) {
    	super(firstname, lastname, 1, login, password, password);
    }
    
    
//*****************************************************************************************************************
	
	public List<Subject> getSujets() {
		return sujets;
	}
	public void setSujets(List<Subject> sujets) {
		this.sujets = sujets;
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
