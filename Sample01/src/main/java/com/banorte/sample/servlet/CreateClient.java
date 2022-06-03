package com.banorte.sample.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CreateClient
 */
@WebServlet("/CreateClient")
public class CreateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateClient() {
        // TODO Auto-generated constructor stub
    }

    //@Resource(name="urlservice1")
    private String u1;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String u1 = "";
		try
		{
			InitialContext ctx = new InitialContext();
			u1 = (String)ctx.lookup("java:comp/env/urlservice1");
			System.out.println("Service URL " + u1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		URL url = new URL(u1 + "?name=" + request.getParameter("nm_client") + "&email=" + request.getParameter("nm_email"));
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setDoOutput(false);


		

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();
		response.sendRedirect("index.html");
		
		
	}

}
