package fr.imie.gmm.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;



@Entity
@Table(name="administrator")
public class Administrator extends User {
	

////***************************************************************************
    //constructor
    
    public Administrator(String firstname,String lastname,String login,String password, String email) {
    	super (firstname, lastname, login, password, email, 3);
    }
    
    public Administrator(){
    	
    }  
////***************************************************************************

}
