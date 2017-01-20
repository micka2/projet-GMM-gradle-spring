package fr.imie.gmm.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fr.imie.gmm.entities.base.EntityBase;



@Inheritance
@Entity
	@Table(name = "users")	// porte le create de la table dans la DB
	public class User extends EntityBase {

	  // The entity fields (private)  

	@NotNull
	private String email;
	@Column(name="Prenom")@NotNull
	protected String firstname;
	@Column(name="Nom")@NotNull
	@JoinColumn(name="userName")
	protected String lastname;
	@Column@NotNull
	@ManyToOne
	@JoinColumn(name="category")
	protected int categoryId;
	@Column@NotNull
	protected String login;
	@Column@NotNull
	protected String password;
	
	
	


	  // Public methods
	
	public User() {

	}

	  public User (String login, String password){
		  this.login=login;
		  this.password=password;
	  }
	  
	  
	  public User(String firstname, String lastname, int categoryId,
				String login, String password, String email) {
					
			this.firstname = firstname;
			this.lastname = lastname;
			this.categoryId = categoryId;
			this.login = login;
			this.password = password;
			this.email = email;
			
		}
	    public User(long id) {
			
			this.firstname ="";
			this.lastname ="";
			this.categoryId =0;
			this.login ="";
			this.password ="";
			this.email="";
		}
	  
	  // Getters and setters methods
	  // ...
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

