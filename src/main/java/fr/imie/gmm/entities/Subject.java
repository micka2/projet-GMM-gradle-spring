package fr.imie.gmm.entities;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import java.util.Date;
import fr.imie.gmm.entities.base.EntityBase;



@Inheritance
@Entity
public class Subject extends EntityBase {


	    
	
	    private String title;
	    private Date createAt;
	    private Date deadline;
	    private String description;
	    private int groupSize;
	    @ManyToMany(targetEntity=Teacher.class)
	    private Teacher createBy;
	    @ManyToMany(mappedBy="name", fetch=FetchType.LAZY)
	    private Promotion promotion;
	    
	    
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
		
		public Subject(String title, Date createAt, Date deadline, String description,String promotion, String teacher) {
				this.title= title;
				this.createAt = createAt;
				this.deadline = deadline;
				this.description = description;
				this.promotion = new Promotion();
				this.createBy = new Teacher();
		}

		/**
		 * @return the promotion
		 */
		public Promotion getPromotion() {
			return promotion;
		}

		/**
		 * @param promotion the promotion to set
		 */
		public void setPromotion(Promotion promotion) {
			this.promotion = promotion;
		}

		
}
