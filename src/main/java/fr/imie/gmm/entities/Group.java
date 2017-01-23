package fr.imie.gmm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

import fr.imie.gmm.entities.base.EntityBase;



@Entity
@Inheritance
public class Group extends EntityBase {

  

    // Attributs de la Classe
    
	@Column(nullable= false, length=35, name="studentGroup")
    private String groupName;
    
    /**
     * Getters and Setters
     */
  
	public String getGroup_name() {
		return groupName;
	}

	public void setGroup_name(String group_name) {
		this.groupName = group_name;
	}
	
	/**
	 * Constructeur
	 */
	public Group(String Group_name){
		this.groupName = Group_name;
	}
	
	//Empty constructor
	public Group (){
		
	}
   

}
