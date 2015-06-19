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
import com.Club.Model.Activity;


/*当用户要参加活动时执行
 * 从数据库中取出未结束的活动
 * 存储在session并转发给joinActivity.jsp
 */

@WebServlet("/ShowActivity")
public class ShowActivityServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ShowActivityServlet(){
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	
	public void execute(HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session=request.getSession();
		String account=(String)session.getAttribute("account");
		
		
		//默认转向错误页面
		String jspAddress="/jsp/editProfileFailure.jsp";
		ArrayList<Activity> activity=ServiceFactory.getActivityServiceInstance().getUnDueActivity(account);
		
		
		if(activity!=null){
			jspAddress="/jsp/joinActivity.jsp";
			session.setAttribute("activity",activity);
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
