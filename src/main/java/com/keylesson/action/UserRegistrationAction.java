package com.keylesson.action;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.keylesson.dao.UserDAO;
import com.keylesson.form.UserForm;

public class UserRegistrationAction //extends Action 
{

//	public ActionForward execute(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("UserRegistrationAction");
//		UserForm userForm = (UserForm) form;
//		String login = userForm.getLogin();
//		String name = userForm.getName(); 
//		Integer age = userForm.getAge();
//		String phone = userForm.getPhone();
//		String email = userForm.getEmail();
//		String password = userForm.getPassword();
//		String result = new UserDAO().createUser(login,name,age,phone,email,password);
//		if(result.equals("success")){
//			request.setAttribute("success", true);
//			userForm.reset();
//		}else{
//			request.setAttribute("failure", true);
//		}
//		return mapping.findForward("add");
//	}
}
