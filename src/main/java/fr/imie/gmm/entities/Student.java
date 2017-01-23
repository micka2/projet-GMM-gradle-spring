package fr.imie.gmm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Student extends User{

	@Column
	@ManyToMany(targetEntity=Group.class, fetch=FetchType.LAZY)
	private int group_id;
	@Column
	@ManyToOne(targetEntity=Promotion.class, fetch=FetchType.EAGER)
    private int promotion_id;
	
	//************************************************************************************************************
    //redefinition du(des) constructeur(s) de la classe Student
    
    public Student() {
    	
    }
    public Student(String firstname,String lastname,String login,int categoryId,String password){
    	super(firstname, lastname, 2, login, password, password);
    }
    
    //************************************************************************************************************
    //getters et setters
    
 
	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getPromotion_id() {
		return promotion_id;
	}

	public void setPromotion_id(int promotion_id) {
		this.promotion_id = promotion_id;
	}
	
	@Override
    public String toString() {
        return String.format("User[id=%d, username='%s'",
                
                this.login);
        }
}
