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
import com.Club.Model.JoinedRecord;
import com.Club.Model.PayRecord;
import com.Club.Model.PersonalMember;

/*
 * 
 * 
 * 
 */

@WebServlet("/ShowPersonal")
public class PersonInfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonInfoServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);}
	public void execute(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/waitress/opFailure.jsp";
		
		HttpSession session=request.getSession();
		int index=Integer.parseInt(request.getParameter("index"));
		
		session.setAttribute("index",index);
		
		@SuppressWarnings("unchecked")
		ArrayList<PersonalMember> member=(ArrayList<PersonalMember>)session.getAttribute("personal");
		if(member!=null){
			PersonalMember selected=member.get(index);
			String account=selected.getAccount();
			
			ArrayList<JoinedRecord> activity=ServiceFactory.getParticipateServiceInstance().findJoinedActivity(account);
			ArrayList<PayRecord> record=ServiceFactory.getPayRecordServiceInstance().getPayRecord(account);
		if(activity!=null&&record!=null){
			session.setAttribute("activity", activity);
			session.setAttribute("record", record);
			jspAddress="/jsp/waitress/personalInfo.jsp";
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
