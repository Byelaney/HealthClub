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
import com.Club.Model.CoachUsePO;

@WebServlet("/GetCoachPOByManager")
public class GetCoachPOServlet extends HttpServlet{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GetCoachPOServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	public void execute(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/manager/opFailure.jsp";
		CoachUsePO coachUsePO=ServiceFactory.getStatisticsServiceInstance().findCoachUsePO();
		if(coachUsePO!=null){
			HttpSession session=request.getSession();
			session.setAttribute("coachPO", coachUsePO);
			jspAddress="/jsp/manager/coachPO.jsp";
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
