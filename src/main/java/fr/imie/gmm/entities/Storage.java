package fr.imie.gmm.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import fr.imie.gmm.entities.base.EntityBase;

@Entity
@Inheritance
@Table(name="Storage")
public class Storage extends EntityBase{
	
	@Column(name = "url", nullable = false, length = 100)
	private String url;
	
	@Column(nullable = false)
	private int size;
	
	@Column(nullable=true)
	private int quota;
	
	///// Initialize getters and setters. /////
	
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the quota
	 */
	public int getQuota() {
		return quota;
	}
	/**
	 * @param quota the quota to set
	 */
	public void setQuota(int quota) {
		this.quota = quota;
	}
	
	

}
