package fr.imie.gmm.interoperabilite;



public class StudentJsonLdap {
	
	private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private InGradeJson inGrade;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public InGradeJson getInGrade() {
		return inGrade;
	}
	public void setInGrade(InGradeJson inGrade) {
		this.inGrade = inGrade;
	} 

}
