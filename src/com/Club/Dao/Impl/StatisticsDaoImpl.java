package com.Club.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Club.Dao.DaoHelper;
import com.Club.Dao.StatisticsDao;
import com.Club.Model.CoachUsePO;
import com.Club.Model.MemberInfoPO;
import com.Club.Model.MonthPO;

public class StatisticsDaoImpl implements StatisticsDao{

	private static StatisticsDaoImpl StatisticsDao=new StatisticsDaoImpl();
	private DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	private StatisticsDaoImpl(){
		
	}
	
	public static StatisticsDaoImpl getInstance(){
		return StatisticsDao;
	}
	
	
	public MonthPO findMonthPO() {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		 int Jan=0;
		 int Feb=0;
		 int Mar=0;
		 int April=0;
		 int May=0;
		 int June=0;
		 int July=0;
		 int Aug=0;
		 int Sep=0;
		 int Oct=0;
		 int Nov=0;
		 int Dec=0;
		
			
		try{
			ps=con.prepareStatement("select * from participate");
			rs=ps.executeQuery();
			while(rs.next()){
				String temp=rs.getString("time");
				String []arr=temp.split("/");
				int Month=Integer.parseInt(arr[1]);
				switch(Month){
					case 1:Jan++;
						   break;
					case 2:Feb++;
					   	   break;
					case 3:Mar++;
					   	   break;
					case 4:April++;
					   	   break;
					case 5:May++;
						   break;
					case 6:June++;
					   	   break;
					case 7:July++;
					       break;
					case 8:Aug++;
					   	   break;
					case 9:Sep++;
					   	   break;
					case 10:Oct++;
					   	   break;
					case 11:Nov++;
					   	   break;
					case 12:Dec++;
					   	   break;		
				}
			}
			
			MonthPO monthPo=new MonthPO(Jan,
			 Feb,
			 Mar,
			 April,
			 May,
			 June,
			 July,
			 Aug,
			 Sep,
			 Oct,
			 Nov,
			 Dec);
			
			return monthPo;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closeResult(rs);
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		
		return null;
	}

	
	public CoachUsePO findCoachPO() {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int Mike=0;
		int Marshal=0;
		int Suby=0;
		int Tom=0;
		
		try{
			ps=con.prepareStatement("select * from activity");
			rs=ps.executeQuery();
			while(rs.next()){
				String coach=rs.getString("coach");
				if(coach.equals("Mike")){
					Mike++;
				}else if(coach.equals("Marshal")){
					Marshal++;
				}else if(coach.equals("Suby")){
					Suby++;
				}else if(coach.equals("Tom")){
					Tom++;
				}
			}
			
			CoachUsePO po=new CoachUsePO(Mike,Marshal,Suby,Tom);
			return po;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closeResult(rs);
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		
		return null;
	}

	
	public MemberInfoPO findMemberInfoPO() {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		 int age10_25=0;
		 int age25_40=0;
		 int age40_55=0;
		 int age55_70=0;
		
		 int male=0;
		 int female=0;
		
		
		 int normal=0;
		 int cease=0;
		 int pause=0;
		 int cancel=0;
		
		try{
			ps=con.prepareStatement("select * from personalmember");
			rs=ps.executeQuery();
			while(rs.next()){
				String gender=rs.getString("gender");
				int age=rs.getInt("age");
				String state=rs.getString("memberstate");
				
				if(gender.equals("male")){
					male++;
				}else{
					female++;
				}
				
				if(state.equals("normal")){
					normal++;
				}else if(state.equals("cease")){
					cease++;
				}else if(state.equals("pause")){
					pause++;
				}else {cancel++;}
				
				if(age<25&&age>=10){
					age10_25++;
				}else if(age>=25&&age<40){
					age25_40++;
				}else if(age>=40&&age<55){
					age40_55++;
				}else {age55_70++;}
				
			}
			
			
				ps=con.prepareStatement("select * from housemember");
				rs=ps.executeQuery();
				while(rs.next()){
					String gender=rs.getString("gender");
					String state=rs.getString("memberstate");
					if(gender.equals("male")){
						male++;
					}else{
						female++;
					}
					
					
					if(state.equals("normal")){
						normal++;
					}else if(state.equals("cease")){
						cease++;
					}else if(state.equals("pause")){
						pause++;
					}else {cancel++;}
				}
			MemberInfoPO po=new MemberInfoPO(age10_25,
			age25_40,
			age40_55,
			age55_70,
			male,
			female,
			normal,
			cease,
			pause,
			cancel);
				
			return po;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closeResult(rs);
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		return null;
	}	
}
