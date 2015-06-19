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
import com.Club.Model.MemberInfoPO;


@WebServlet("/GetMemberInfoPO")
public class GetMemberPOServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GetMemberPOServlet(){
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
		MemberInfoPO memberInfoPO=ServiceFactory.getStatisticsServiceInstance().findMemberInfoPO();
		if(memberInfoPO!=null){
			HttpSession session=request.getSession();
			session.setAttribute("memberInfoPO", memberInfoPO);
			jspAddress="/jsp/manager/memberInfoPO.jsp";
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
