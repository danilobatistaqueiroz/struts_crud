package com.keylesson.action;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.keylesson.dao.UserDAO;
import com.keylesson.form.UserForm;
import com.keylesson.persistence.User;

public class ProductRegistrationAction //extends DispatchAction 
{

//	public ActionForward add(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("add");
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
//	
//	public ActionForward update(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("update");
//		UserForm userForm = (UserForm) form;
//		String name = userForm.getName();
//		Integer age = userForm.getAge();
//		String result = new UserDAO().updateUser(name, age);
//		if(result.equals("success")){
//			request.setAttribute("success", true);
//			userForm.reset();
//		}else{
//			request.setAttribute("failure", true);
//		}
//
//		List<User> users = new UserDAO().getUsers(name);
//		System.out.println("users:"+users.size());
//		request.setAttribute("users", users);
//		return mapping.findForward("search");
//	}

}
