package com.banorte.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.banorte.sample.dto.Cliente;

public class DBConnection {

	@Resource(name="jdbc/myConn", lookup="jdbc/myconn")
	private DataSource ds;
	public List<Cliente> getClientList()
	{
		ArrayList<Cliente> list = new ArrayList<Cliente>();
		
		try
		{
			InitialContext ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:comp/env"); 
			ds = (DataSource)envCtx.lookup("jdbc/myConn");
			Connection con =ds.getConnection();
			PreparedStatement ps = con.prepareStatement("select cd_client, nm_client, nm_email from client");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Cliente cli = new Cliente();
				cli.setId(rs.getLong("cd_client"));
				cli.setName(rs.getString("nm_client"));
				cli.setEmail(rs.getString("nm_email"));
				list.add(cli);
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public void addClient(String name, String email)
	{
		try
		{
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myConn");
			Connection con =ds.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into client (nm_client, nm_email) values (?, ? )");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.execute();
			
			ps.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
