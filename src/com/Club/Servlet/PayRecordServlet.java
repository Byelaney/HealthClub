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
import com.Club.Model.PayRecord;


/*用户在index页面点击查看付款记录
 * 从数据库读数据并存储在session中
 * 跳转到payRecord.jsp
 */

@WebServlet("/PayRecord")
public class PayRecordServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PayRecordServlet(){
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
		
		ArrayList<PayRecord> payRecord=new ArrayList<PayRecord>();
		payRecord=ServiceFactory.getPayRecordServiceInstance().getPayRecord(account);
		if(payRecord!=null){
			session.setAttribute("payrecord",payRecord);
			jspAddress="/jsp/payRecord.jsp";
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
