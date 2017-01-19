package fr.imie.gmm.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;


@Entity
@Inheritance
public class Administrator extends User {

	private Teacher teach=null;
    private Student student=null;
    private User user=null;
    
//***************************************************************************
    //constructor
    
    public Administrator(String firstname,String lastname,String login,String password) {
    	super (firstname, lastname,3, login, password, password);
    }
    
//    public Administrator(){
//    	
//    }  
//***************************************************************************
	// getters & setters
    
	public Teacher getTeach() {
		return teach;
	}
	public void setTeach(Teacher teach) {
		this.teach = teach;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
//****************************************************************************

	
}
