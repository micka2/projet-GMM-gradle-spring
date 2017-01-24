package fr.imie.gmm.entities;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import fr.imie.gmm.entities.base.EntityBase;



@Entity
@Inheritance
@Table(name="WorkingGroup")
public class WorkingGroup extends EntityBase {

  
    private String groupName;
    
    /**
     * Getters and Setters
     */
  
	public String getGroupName() {
		return groupName;
	}

	public void setGroup_name(String groupName) {
		this.groupName = groupName;
	}
	
	/**
	 * Constructeur
	 */
	public WorkingGroup(String GroupName){
		this.groupName = GroupName;
	}
	
	//Empty constructor
	public WorkingGroup (){
		
	}
   

}
