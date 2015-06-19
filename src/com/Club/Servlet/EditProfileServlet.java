package com.Club.Servlet;

import java.io.IOException;

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

/*当用户在edit(2).jsp 填写完成要修改的内容后 执行
 * 调用相关Service更新数据库
 * 根据更新结果来转发到下一个jsp
 */


@WebServlet("/EditProfile")
public class EditProfileServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditProfileServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		execute(request,response);
	}
	
	public void execute(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/editProfileFailure.jsp";
		
		HttpSession session=request.getSession();
		String type=(String)session.getAttribute("type");
		
		if(type.equals("personal")){
			
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			int age=Integer.parseInt(request.getParameter("age"));
			String gender=request.getParameter("gender");
			
			PersonalMember personalMember=(PersonalMember)session.getAttribute("member");
			
			if(personalMember!=null){
				personalMember.setPassword(password);
				personalMember.setAddress(address);
				personalMember.setAge(age);
				personalMember.setGender(gender);
				
				boolean isSucceed=ServiceFactory.getPersonalServiceInstance().updatePersonalMember(personalMember);
				if(isSucceed){
					jspAddress="/jsp/editProfileSucceed.jsp";
					session.setAttribute("member",personalMember);
				}
				
			}
			
			
		}
		else if(type.equals("house")){
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			int couples=Integer.parseInt(request.getParameter("couples"));	
			int children=Integer.parseInt(request.getParameter("children"));
			String gender=request.getParameter("gender");
			
			HouseMember houseMember=(HouseMember)session.getAttribute("member");
			houseMember.setPassword(password);
			houseMember.setAddress(address);
			houseMember.setCouples(couples);
			houseMember.setChildren(children);
			houseMember.setGender(gender);
			
			boolean isSucceed=ServiceFactory.getHouseServiceInstance().updateHouseMember(houseMember);
			if(isSucceed){
				jspAddress="/jsp/editProfileSucceed.jsp";
				session.setAttribute("member",houseMember);
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
