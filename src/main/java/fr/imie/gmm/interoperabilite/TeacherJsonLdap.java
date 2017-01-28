package fr.imie.gmm.interoperabilite;

public class TeacherJsonLdap {
	
	private int iD;
    private String creatAt;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getCreatAt() {
		return creatAt;
	}
	public void setCreatAt(String creatAt) {
		this.creatAt = creatAt;
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

}
