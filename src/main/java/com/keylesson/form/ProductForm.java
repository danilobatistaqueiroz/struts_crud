package com.keylesson.form;

import org.apache.struts.action.ActionForm;

public class ProductForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String dispatch;
	private String name;


	public void reset() {
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

}
