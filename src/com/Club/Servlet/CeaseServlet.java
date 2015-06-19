package com.Club.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Club.Factory.DaoFactory;
import com.Club.Model.HouseMember;
import com.Club.Model.PersonalMember;


@WebServlet("/CeaseUser")
public class CeaseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CeaseServlet(){
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		execute(request,response);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		execute(request,response);
	}
	
	public void execute(HttpServletRequest request,
		HttpServletResponse response)throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		String Usertype=(String)session.getAttribute("type");
		if(Usertype.equals("house")){
			HouseMember houseMember=(HouseMember)session.getAttribute("member");
			houseMember.setMemberState("cease");
			DaoFactory.getHouseMemberDao().updateHouseMember(houseMember);
		}else if(Usertype.equals("personal")){
			PersonalMember personalMember=(PersonalMember)session.getAttribute("member");
			personalMember.setMemberstate("cease");
			DaoFactory.getPersonalMemberDao().updatePersonalMember(personalMember);
		}
		
		session.setAttribute("logged", false);
		session.invalidate();
		response.sendRedirect("");
	}
	
}
