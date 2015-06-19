package com.Club.Servlet.Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Club.Factory.ServiceFactory;
import com.Club.Model.HouseMember;

@WebServlet("/EditFamilyByAdmin")
public class EditFamilyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EditFamilyServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	
	
	public void execute(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/waitress/opFailure.jsp";
		HttpSession session=request.getSession();
		int selectedIndex=Integer.parseInt(request.getParameter("selectedFamily"));
		@SuppressWarnings("unchecked")
		ArrayList<HouseMember> list=(ArrayList<HouseMember>)session.getAttribute("family");
		HouseMember member=list.get(selectedIndex);
		if(list!=null){
			if(member!=null){
				session.setAttribute("editFamilyInfo", member);
				jspAddress="/jsp/waitress/editFamily.jsp";
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
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/waitress/opFailure.jsp";
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		int couples=Integer.parseInt(request.getParameter("couples"));
		int children=Integer.parseInt(request.getParameter("children"));
		String gender=request.getParameter("gender");
		
		HttpSession session=request.getSession();
		HouseMember member=(HouseMember)session.getAttribute("editFamilyInfo");
		if(member!=null){
			member.setPassword(password);
			member.setAddress(address);
			member.setCouples(couples);
			member.setChildren(children);
			member.setGender(gender);
			
			boolean isSucceed=ServiceFactory.getHouseServiceInstance().updateHouseMember(member);
			if(isSucceed){
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
