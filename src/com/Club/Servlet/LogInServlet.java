package com.Club.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Club.Factory.*;
import com.Club.Model.HouseMember;
import com.Club.Model.PersonalMember;

/*用户在填写完用户名与密码后执行，完成一系列验证操作
 * 成功则转向index.jsp
 * 并在session中添加一些信息
 */

@WebServlet("/LogIn")
public class LogInServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogInServlet(){
		super();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		execute(request,response);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response){
		
	}
	
	public void execute(HttpServletRequest request,
			HttpServletResponse response){
		
		String accounttype=request.getParameter("type");
		String jspAddress="/jsp/loginFailure.jsp";
				
		if(accounttype!=null){
		if(accounttype.equals("personal")){
			PersonalMember member=ServiceFactory.getPersonalServiceInstance()
					.validate(request.getParameter("account"),
					request.getParameter("password"));
			
			if(member!=null&&member.getMemberstate().equals("normal")){
				HttpSession session = request.getSession(true);
				session.setAttribute("logged", true);
				session.setAttribute("member", member);
				session.setAttribute("type","personal");
				session.setAttribute("account",member.getAccount());
				//定位到登陆后的主页面
				jspAddress="/jsp/index.jsp";
			}
		}
		else if(accounttype.equals("house")){
			HouseMember member=ServiceFactory.getHouseServiceInstance()
					.validate(request.getParameter("account"),
							request.getParameter("password"));
			
			
			if(member!=null&&member.getMemberState().equals("normal")){
				
				HttpSession session = request.getSession(true);
				session.setAttribute("logged", true);
				session.setAttribute("member", member);
				session.setAttribute("type","house");
				session.setAttribute("account",member.getAccount());
				//定位到登录后的主页面
				jspAddress="/jsp/index.jsp";
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
