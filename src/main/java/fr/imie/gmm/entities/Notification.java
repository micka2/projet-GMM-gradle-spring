package fr.imie.gmm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import fr.imie.gmm.entities.base.EntityBase;



@Entity
@Table(name="Notification")
public class Notification extends EntityBase {

//	@Column (nullable = false, length = 300)
    private String message;
//	@Column (nullable =  false, length = 50)
    private String titleMessage;
    
    
    

	   /**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the titleMessage
	 */
	public String getTitleMessage() {
		return titleMessage;
	}

	/**
	 * @param titleMessage the titleMessage to set
	 */
	public void setTitleMessage(String titleMessage) {
		this.titleMessage = titleMessage;
	}

	/**
     * constructor
     */
    public Notification(String message, String titleMessage) {
    	this.message= message;
    	this.titleMessage= titleMessage;
    }
    
    //Empty constructor
    public Notification(){
    	
    }
	
}
