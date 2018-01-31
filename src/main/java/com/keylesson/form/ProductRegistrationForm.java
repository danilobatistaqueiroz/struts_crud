package com.keylesson.form;

//import org.apache.struts.validator.ValidatorForm;

public class ProductRegistrationForm //extends ValidatorForm 
{
	private static final long serialVersionUID = 1L;

	private String dispatch;
	private String name;
	private Double price;
	private String productType;

	public void reset() {
		this.name = null;
		this.price = null;
		this.productType = null;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
