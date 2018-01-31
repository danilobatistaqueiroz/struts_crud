package com.keylesson.form;

//import org.apache.struts.validator.ValidatorForm;

public class UserRegistrationForm //extends ValidatorForm 
{
	private static final long serialVersionUID = 1L;

	private String login;
	private String name;
	private Integer age;
	private String phone;
	private String email;
	private String password;

	public void reset() {
		this.login = null;
		this.name = null;
		this.age = null;
		this.phone = null;
		this.email = null;
		this.password = null;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
