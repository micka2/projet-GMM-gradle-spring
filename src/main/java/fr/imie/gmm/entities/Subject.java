package fr.imie.gmm.entities;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import java.util.Date;
import fr.imie.gmm.entities.base.EntityBase;



@Inheritance
@Entity
public class Subject extends EntityBase {
	
	private String title;
	private String describe;
	private String contraintes;
	private Date   deadline;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getContraintes() {
		return contraintes;
	}
	public void setContraintes(String contraintes) {
		this.contraintes = contraintes;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
}
