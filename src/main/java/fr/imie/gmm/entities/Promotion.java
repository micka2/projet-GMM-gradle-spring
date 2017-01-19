package fr.imie.gmm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

package fr.imie.gmm.entities.base.EntityBase;

@Entity
@Inheritance
public class Promotion extends EntityBase {

  
     @Column(nullable = false, length = 20)
    private String name;
    @Column 
    private Integer year;
    
    /**
     * Getters and Setters
     */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

	  /**
     *  constructor
     */
    public Promotion(String Name, Integer Year) {
    	this.name= Name;
    	this.year= Year;
    }

    // empty constructor
    
    public Promotion (){
    	
    }
    
}
