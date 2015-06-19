package com.Club.Servlet.Admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Club.Factory.ServiceFactory;
import com.Club.Model.Activity;

/*接收arrange.jsp的表单
 * 生成新的activity并更新数据库
 * 之后跳转成功或失败页面
 */


@WebServlet("/Arrangement")
public class ArrangeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArrangeServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	
	public void execute(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/waitress/opFailure.jsp";
		
		String ground=request.getParameter("ground");
		String coach=request.getParameter("coach");
		String string_date=request.getParameter("date");
		String time=request.getParameter("time");
		Date date=null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date=dateFormat.parse(string_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Activity activity=new Activity();
		activity.setCoach(coach);
		activity.setGround(ground);
		activity.setDate(date);
		activity.setTime(time);
		
		boolean isSucceed=ServiceFactory.getActivityServiceInstance().addActivity(activity);
		
		if(isSucceed){
			jspAddress="/jsp/waitress/opSucceed.jsp";
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
