package fr.imie.gmm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator extends User{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long adminId;
	private Teacher teach=null;
    private Student student=null;
    private User user=null;
    
//***************************************************************************
    //constructor
    
    public Administrator(String firstname,String lastname,String login,String password) {
    	super (firstname, lastname,3, login, password);
    }
    
    public Administrator(){
    	
    }  
//***************************************************************************
	// getters & setters
    
    public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
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
