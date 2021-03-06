package com.banorte.sample.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banorte.sample.DBConnection;

/**
 * Servlet implementation class RestClient
 */
@WebServlet("/RestClient")
public class RestClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Adding a new Client");
		DBConnection con = new DBConnection();
		con.addClient(request.getParameter("name"), request.getParameter("email"));
		response.sendRedirect("index.html");
	}

}
