package com.Club.Servlet.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Club.Factory.ServiceFactory;
import com.Club.Model.PersonalMember;


@WebServlet("/EditPersonalByAdmin")
public class EditPersonalServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EditPersonalServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	
	public void execute(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/waitress/opFailure.jsp";
		HttpSession session=request.getSession();
		PersonalMember member=(PersonalMember)session.getAttribute("selectedPersonal");
		if(member!=null){
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		member.setPassword(password);
		member.setAddress(address);
		member.setAge(age);
		member.setGender(gender);
		
		boolean isSucceed=ServiceFactory.getPersonalServiceInstance().updatePersonalMember(member);
		if(isSucceed){
			session.setAttribute("selectedPersonal",member);
			jspAddress="/jsp/waitress/opSucceed.jsp";
		}
		
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspAddress);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
