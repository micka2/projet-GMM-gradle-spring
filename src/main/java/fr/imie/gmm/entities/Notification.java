package fr.imie.gmm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

import com.springapp.models.base.EntityBase;

@Entity
@Inheritance
public class Notification extends EntityBase {

	@Column (nullable = false, length = 300)
    private String Message;
	@Column (nullable =  false, length = 50)
    private String titleMessage;
    
    
    /**
     *Getters and Setters
     */
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getTitleMessage() {
		return titleMessage;
	}
	public void setTitleMessage(String titleMessage) {
		this.titleMessage = titleMessage;
	}

	   /**
     * constructor
     */
    public Notification(String message, String titleMessage) {
    	this.Message= message;
    	this.titleMessage= titleMessage;
    }
    
    //Empty constructor
    public Notification(){
    	
    }
	
}
