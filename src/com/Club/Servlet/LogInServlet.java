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

/*�û�����д���û����������ִ�У����һϵ����֤����
 * �ɹ���ת��index.jsp
 * ����session�����һЩ��Ϣ
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
				//��λ����½�����ҳ��
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
				//��λ����¼�����ҳ��
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
