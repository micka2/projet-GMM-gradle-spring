package fr.imie.gmm.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


import fr.imie.gmm.entities.base.EntityBase;


	
@Entity
@Table(name="User")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
 public class User extends EntityBase {



//	@Column(name="fistName")@NotNull
	protected String firstname;
//	@Column(name="lastName")@NotNull
	protected String lastname;
//	@Column@NotNull
	protected String login;
//	@Column@NotNull
	protected String password;
//	@NotNull
	private String email;
	protected int categoryId;
		


	  // Public methods
	
	public User() {
		super();
	}

	  public User (String login, String password){
		  super();
		  this.login=login;
		  this.password=password;
	  }
	  
	  
	  public User(String firstname, String lastname, String login, 
			  String password, String email, int categoryId) {
				super();	
			this.firstname = firstname;
			this.lastname = lastname;
			this.login = login;
			this.password = password;
			this.email = email;
			this.categoryId = categoryId;
			
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

	/**
	 * @return the category
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	
}

