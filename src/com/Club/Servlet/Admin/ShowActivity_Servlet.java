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
import com.Club.Model.Activity;

/*waitress.jsp的显示当前所有未过期活动请求
 * 从数据库取得活动并存储在session中
 * 跳转到activity_waitress.jsp页面
 * 
 */


@WebServlet("/ShowActivity_2")
public class ShowActivity_Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ShowActivity_Servlet(){
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
		
		//默认转向错误页面
		String jspAddress="/jsp/editProfileFailure.jsp";
		ArrayList<Activity> activity=ServiceFactory.getActivityServiceInstance().getUnDueActivity();
		
		
		if(activity!=null){
			jspAddress="/jsp/waitress/activity_waitress.jsp";
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
