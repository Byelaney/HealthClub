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
import com.Club.Model.ClubManager;
import com.Club.Model.Waitress;

/*接收login2.html的登录请求
 * 进行验证并提示
 * 跳转到相应页面
 */

@WebServlet("/LogIn_2")
public class LogIn_2Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogIn_2Servlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	public void execute(HttpServletRequest request,HttpServletResponse response){
		
		String accounttype=request.getParameter("type");
		String jspAddress="/jsp/loginFailure.jsp";
			
		if(accounttype!=null){
		if(accounttype.equals("manager")){
			ClubManager manager=ServiceFactory.getManagerServiceInstance()
					.validate(request.getParameter("account"),
					request.getParameter("password"));
			
			if(manager!=null){
				HttpSession session = request.getSession(true);
				session.setAttribute("logged", true);
				session.setAttribute("member", manager);
				session.setAttribute("type","manager");
				
				//定位到登陆后的主页面
				jspAddress="/jsp/manager/manager.jsp";
			}
		}
		else if(accounttype.equals("waitress")){
			Waitress waitress=ServiceFactory.getWaitressServiceInstance().
					validate(request.getParameter("account"),
							request.getParameter("password"));
			
			if(waitress!=null){
				
				HttpSession session = request.getSession(true);
				session.setAttribute("logged", true);
				session.setAttribute("member", waitress);
				session.setAttribute("type","waitress");
				
				//定位到登录后的主页面
				jspAddress="/jsp/waitress/waitress.jsp";
			}
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
