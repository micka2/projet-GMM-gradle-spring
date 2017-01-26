package fr.imie.gmm.entities;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;




@Entity
//@Table(name="Student")
public class Student extends User{
	
	
	
	@ManyToOne
	private WorkingGroup groupId;
	@ManyToOne
    private Grade gradeId;
	
	//************************************************************************************************************
    //redefinition du(des) constructeur(s) de la classe Student
    
    public Student() {
    	super();   	
    }
    
    public Student(String firstname,String lastname,String login,String password,int category){
    	super(firstname, lastname, login, password, password, 2);
    }
	
    
    
    //************************************************************************************************************
    //getters et setters
    
    /**
	 * @return the groupId
	 */
	public WorkingGroup getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
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
	 * @param promotionId the promotionId to set
	 */
	public void setPromotionId(Grade gradeId) {
		this.gradeId = gradeId;
	}
	
	
	
	@Override
    public String toString() {
        return String.format("User[id=%d, username='%s'",
                
                this.login);
        }
}
