package com.Club.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.Club.Dao.DaoHelper;

public class DaoHelperImpl implements DaoHelper{

	
private static DaoHelperImpl baseDao=new DaoHelperImpl();
	
	private InitialContext jndiContext = null;
	private Connection connection = null;
	private DataSource datasource = null;
	
	
	public static DaoHelperImpl getBaseDaoInstance(){
		return baseDao;
	}
	
	
	private DaoHelperImpl(){
		Properties  properties=new Properties();
		properties.put(javax.naming.Context.PROVIDER_URL, "jnp:///");
		properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,"org.apache.naming.java.javaURLContextFactory");
		
		try{
			jndiContext=new InitialContext(properties);
			datasource = (DataSource) jndiContext.lookup("java:comp/env/jdbc/healthclub");
			
		}catch(NamingException e){
			e.printStackTrace();
		}
		
	}
	
	
	
	public Connection getConnection() {
		
		try{
			connection=datasource.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}

	
	public void closeConnection(Connection con) {
		
		if(con!=null){
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		}	
	}

	
	public void closePreparedStatement(PreparedStatement stmt) {
		
		if(stmt!=null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				
			}
			
		}
		
	}

	
	public void closeResult(ResultSet result) {
		
		if(result!=null){
			try{
				result.close();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
	}


}
