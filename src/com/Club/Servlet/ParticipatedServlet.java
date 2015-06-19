package com.Club.Servlet;

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

/*用户查看自己参加过的活动时执行
 * 从数据库获得参加过的活动
 * 将数据存储在session中
 * 转发给participatedActivity.jsp
 */
@WebServlet("/JoinedRecord")
public class ParticipatedServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParticipatedServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	
	public void execute(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/editProfileFailure.jsp";
		
		HttpSession session=request.getSession();
		String account=(String)session.getAttribute("account");
		ArrayList<JoinedRecord> record=ServiceFactory.getParticipateServiceInstance().findJoinedActivity(account);
		if(record!=null){
			jspAddress="/jsp/participatedActivity.jsp";
			session.setAttribute("record",record);
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
