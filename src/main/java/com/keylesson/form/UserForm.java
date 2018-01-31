package com.keylesson.form;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String dispatch;
	private String login;
	private String name;

	public void reset() {
		this.login = null;
		this.name = null;
	}

	public String getDispatch() {
		return dispatch;
	}

	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
