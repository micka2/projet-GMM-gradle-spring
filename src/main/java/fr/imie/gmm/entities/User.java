package fr.imie.gmm.entities;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;


import fr.imie.gmm.entities.base.EntityBase;


	
	@Inheritance
	@Table(name = "User")
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
	protected int category;
	
	
	


	  // Public methods
	
	public User() {

	}

	  public User (String login, String password){
		  this.login=login;
		  this.password=password;
	  }
	  
	  
	  public User(String firstname, String lastname, String login, 
			  String password, String email, int category) {
					
			this.firstname = firstname;
			this.lastname = lastname;
			this.login = login;
			this.password = password;
			this.email = email;
			this.category = category;
			
		}
	    public User(long id) {
			
			this.firstname ="";
			this.lastname ="";
			this.login ="";
			this.password ="";
			this.email="";
			this.category=0;
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
	public int getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}
	
}

