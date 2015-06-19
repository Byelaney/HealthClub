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
import com.Club.Model.HouseMember;
import com.Club.Model.PersonalMember;

/*waitress.jsp的查看用户请求
 * 从数据库取出所有个人用户和家庭用户
 * 存储在session中,跳转到members.jsp
 */

@WebServlet("/GetMember")
public class MemberServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	
	public void execute(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/waitress/opFailure.jsp";
		
		ArrayList<PersonalMember> personal=null;
		ArrayList<HouseMember> family=null;
		
		personal=ServiceFactory.getPersonalServiceInstance().findAll();
		family=ServiceFactory.getHouseServiceInstance().findAll();
		
		if(personal!=null&&family!=null){
			HttpSession session=request.getSession();
			session.setAttribute("personal", personal);
			session.setAttribute("family",family);
			
			jspAddress="/jsp/waitress/members.jsp";
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
