package com.Club.Servlet.Admin;

import java.io.IOException;
import java.text.ParseException;
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
import com.Club.Model.PayRecord;

@WebServlet("/EditRecordByAdmin")
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
		String jspAddress="/jsp/waitress/opFailure.jsp";
		int PayrecordID=Integer.parseInt(request.getParameter("payrecordid"));
		String account=request.getParameter("account");
		double payment=Double.parseDouble(request.getParameter("payment"));
		String date=request.getParameter("date");
		
		HttpSession session=request.getSession();
		PayRecord toEdit=(PayRecord)session.getAttribute("editPayRecord");
		toEdit.setPayRecordId(PayrecordID);
		toEdit.setAccount(account);
		toEdit.setPayment(payment);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		Date tempDate=null;
		try {
			 tempDate=dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		toEdit.setDate(tempDate);
	
		boolean isSucceed=ServiceFactory.getPayRecordServiceInstance().update(toEdit);
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
	public void execute(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/waitress/opFailure.jsp";
		int selectedRecord=Integer.parseInt(request.getParameter("selectedRecord"));
		HttpSession session=request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<PayRecord> payRecord=(ArrayList<PayRecord>)session.getAttribute("record");
		if(payRecord!=null){
		PayRecord toEdit=payRecord.get(selectedRecord);
		session.setAttribute("editPayRecord",toEdit);
		jspAddress="/jsp/waitress/editPayRecord.jsp";
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
