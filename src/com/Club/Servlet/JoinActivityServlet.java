package com.Club.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Club.Factory.ServiceFactory;
import com.Club.Model.Participate;

/*当用户在joinActivity.jsp上选择完要参加的活动后
 * 调用相关service更新数据库
 * 根据更新结果来转发到下一个jsp
 */

@WebServlet("/JoinActivity")
public class JoinActivityServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JoinActivityServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	
	public void execute(HttpServletRequest request,HttpServletResponse response){
		
		//默认转向错误页面
		String jspAddress="/jsp/editProfileFailure.jsp";
		String selections[]=request.getParameterValues("selection");
		HttpSession session=request.getSession();
		
		
		ArrayList<Participate> participate=new ArrayList<Participate>();
		
		String account=(String)session.getAttribute("account");
		
		Date nowDate = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式

		String time = dateFormat.format(nowDate); 
		
		
		for(int i=0;i<selections.length;i++){
			int activityID=Integer.parseInt(selections[i]);
			Participate tempParticipate=new Participate();
			tempParticipate.setAccount(account);
			tempParticipate.setActivityId(activityID);
			tempParticipate.setTime(time);
			participate.add(tempParticipate);
		}
		
		boolean isSucceed=ServiceFactory.getParticipateServiceInstance().addParticipate(participate);
		if(isSucceed){
			
			jspAddress="/jsp/editProfileSucceed.jsp";
			
			
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
