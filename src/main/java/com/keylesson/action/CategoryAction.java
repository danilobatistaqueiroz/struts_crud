package com.keylesson.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.keylesson.dao.UserDAO;
import com.keylesson.form.UserForm;
import com.keylesson.persistence.User;

public class CategoryAction extends DispatchAction 
{
//
//	public ActionForward goToEditPage(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		System.out.println("goToEditPage");
//		System.out.println("request(name):"+request.getParameter("user"));
//		List<User> users = new UserDAO().getUsers(request.getParameter("user"));
//		//request.setAttribute("user", (User)users.get(0));
//		
//		HttpSession session = request.getSession();
//	    session.setAttribute("product", (User)users.get(0));
//	    
//		return mapping.findForward("edit");
//	}
//	
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
//	public ActionForward goToAddPage(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		System.out.println("goToAddPage");
//		return mapping.findForward("add");
//	}
//	
//	public ActionForward searchProducts(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		System.out.println("searchProducts");
//		String userName = (String) request.getAttribute("user");
//		//UserForm userForm = (UserForm) form;
//		List<User> users = new UserDAO().getUsers(userName);
//		request.setAttribute("users", users);
//		return mapping.findForward("search");
//	}
//	
//	public ActionForward delProduct(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		System.out.println("delProduct");
//		UserForm userForm = (UserForm) form;
//		System.out.println("user name:" + userForm.getName());
//		System.out.println("price:" + userForm.getAge());
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
