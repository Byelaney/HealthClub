package com.Club.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Club.Factory.DaoFactory;
import com.Club.Factory.ServiceFactory;
import com.Club.Model.HouseMember;
import com.Club.Model.PayRecord;
import com.Club.Model.PersonalMember;

/*处理个人用户注册,完成扣费等操作
 * 成功后 session中存储相关信息
 * 并转向index.jsp
 */

@WebServlet("/PersonalRegister")
public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final double QUALIFYFEE=75;
	
	public RegisterServlet(){
		super();
	}
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		execute(request,response);
	}
	
	public void execute(HttpServletRequest request,HttpServletResponse response){
		String jspAddress="/jsp/registerFailure.jsp";
		
		String account=request.getParameter("account");
		PersonalMember member=ServiceFactory.getPersonalServiceInstance().validateAccount(account);
		HouseMember hm=ServiceFactory.getHouseServiceInstance().validateAccount(account);
		//账号确实不存在
		if(member==null&&hm==null){
			String bankCardAccount=request.getParameter("bankCardAccount");
			double balance=ServiceFactory.getBankCardServiceInstance().findBalance(bankCardAccount);
			
			if(balance!=-1){
			boolean charge=ServiceFactory.getBankCardServiceInstance().charge(bankCardAccount, QUALIFYFEE);
			//注册成功
			if(charge){
				PersonalMember newMember=new PersonalMember();
				newMember.setAccount(request.getParameter("account"));
				newMember.setAddress(request.getParameter("address"));
				String BirthDate=request.getParameter("age");
				String arg[]=BirthDate.split("-");
				int age=2014-Integer.parseInt(arg[0]);
				newMember.setAge(age);
				newMember.setBankCardAccount(request.getParameter("bankCardAccount"));
				newMember.setGender(request.getParameter("gender"));
				newMember.setIdCard(request.getParameter("cardID"));
				newMember.setPassword(request.getParameter("password"));
				//新申请的用户状态为正常
				newMember.setMemberstate("normal");
				boolean isSucceed=ServiceFactory.getPersonalServiceInstance().addPersonalMember(newMember);
				if(isSucceed){
				jspAddress="/jsp/index.jsp";
				//已经登录置为true,并把对象存在session中
				HttpSession session = request.getSession(true);
				session.setAttribute("type","personal");
				session.setAttribute("logged", true);
				session.setAttribute("member", newMember);
				session.setAttribute("account",newMember.getAccount());
				
				PayRecord payRecord=new PayRecord();
				payRecord.setAccount(newMember.getAccount());
				payRecord.setPayment(QUALIFYFEE);
				payRecord.setDate(new Date());
				payRecord.setPayRecordId(0);
				DaoFactory.getPayRecordDao().addPayRecord(payRecord);
				
				
				}
				//否则把钱还给账户
				else {
					ServiceFactory.getBankCardServiceInstance().recover(bankCardAccount, balance);
				}
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
