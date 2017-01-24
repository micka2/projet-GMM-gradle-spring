package fr.imie.gmm.entities;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Student")
public class Student extends User{

	@ManyToOne
	private WorkingGroup groupId;
	@ManyToOne
    private Grade promotionId;
	
	//************************************************************************************************************
    //redefinition du(des) constructeur(s) de la classe Student
    
    public Student() {
    	
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
	public Grade getPromotionId() {
		return promotionId;
	}
	/**
	 * @param promotionId the promotionId to set
	 */
	public void setPromotionId(Grade promotionId) {
		this.promotionId = promotionId;
	}
	public Student(String firstname,String lastname,String login,int categoryId,String password){
    	super(firstname, lastname, login, password, password, 2);
    }
	
	
	@Override
    public String toString() {
        return String.format("User[id=%d, username='%s'",
                
                this.login);
        }
}
