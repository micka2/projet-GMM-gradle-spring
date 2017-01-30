package fr.imie.gmm.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.imie.gmm.entities.base.EntityBase;



@Entity
@Table(name="Subject")
public class Subject extends EntityBase {


	    
	
	    private String title;
	    private Date createAt;
	    private Date deadline;
	    private String description;
	    private String contsraint;
	    private int groupSize;
	    @ManyToOne
	    private Teacher createBy;
	    @ManyToOne
	    private Grade promotion;
	    
	    
	    /**
	     * Getter and Setters
	     */
	    
	    

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}



		public Date getCreateAt() {
			return createAt;
		}

		public void setCreateAt(Date createAt) {
			this.createAt = createAt;
		}


		
		public Date getDeadline() {
			return deadline;
		}

		public void setDeadline(Date deadline) {
			this.deadline = deadline;
		}


		
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}



		public int getGroupSize() {
			return groupSize;
		}

		public void setGroupSize(int groupSize) {
			this.groupSize = groupSize;
		}



		public Teacher getCreateBy() {
			return createBy;
		}

		public void setCreateBy(Teacher createBy) {
			this.createBy = createBy;
		}



	    
	    
	    

		/**
		 * Constructeur
		 */
		public Subject() {
			
		}
		
		public Subject(String title, Date deadline,Date createAt, String description,String constraint) {
				this.title= title;
				this.deadline = deadline;
				this.createAt = new Date();
				this.description = description;
				this.contsraint = constraint;
				
		}

		
		
		/**
		 * @return the promotion
		 */
		public Grade getPromotion() {
			return promotion;
		}

		/**
		 * @param promotion the promotion to set
		 */
		public void setPromotion(Grade promotion) {
			this.promotion = promotion;
		}

		public String getContsraint() {
			return contsraint;
		}

		public void setContsraint(String contsraint) {
			this.contsraint = contsraint;
		}

		
}
