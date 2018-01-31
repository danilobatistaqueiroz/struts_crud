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

public class UserAction //extends DispatchAction 
{

//	public ActionForward goToDeletePage(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		System.out.println("goToDeletePage");
//		System.out.println("request(name):"+request.getParameter("user"));
//		List<User> users = new UserDAO().getUsers(request.getParameter("user"));
//		request.setAttribute("user", (User)users.get(0));
//		return mapping.findForward("del");
//	}
//	
//	public ActionForward goToSearchPage(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		System.out.println("goToSearchPage");
//		return mapping.findForward("search");
//	}
//	
//	public ActionForward goToRegisterPage(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		System.out.println("goToRegisterPage");
//		return mapping.findForward("add");
//	}
//	
//	public ActionForward searchUsers(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		System.out.println("searchUsers");
//		//String userName = (String) request.getAttribute("user");
//		UserForm userForm = (UserForm) form;
//		List<User> users = new UserDAO().getUsers(userForm.getName());
//		request.setAttribute("users", users);
//		return mapping.findForward("search");
//	}
//	
//	public ActionForward delUser(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		System.out.println("delUser");
//		UserForm userForm = (UserForm) form;
//		System.out.println("user name:" + userForm.getName());
//		System.out.println("user age:" + userForm.getAge());
//		String result = new UserDAO().delUser(userForm.getName(), userForm.getAge());
//		if(result.equals("success")){
//			request.setAttribute("success", true);
//			userForm.reset();
//		}else{
//			request.setAttribute("failure", true);
//		}
//		return mapping.findForward("search");
//	}

}
