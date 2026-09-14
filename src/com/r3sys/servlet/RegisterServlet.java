package com.r3sys.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.reminderdb.ConnectDB;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String uname = request.getParameter("uname");
        String ucontact = request.getParameter("ucontact");
        String uemail = request.getParameter("uemail");
        String upassword = request.getParameter("upassword");

        try {

            Connection con = ConnectDB.connect();

            String sql =
            "insert into user(uname,ucontact,uemail,upassword) values(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, uname);
            ps.setString(2, ucontact);
            ps.setString(3, uemail);
            ps.setString(4, upassword);

            int i = ps.executeUpdate();

            if(i>0)
            {
                response.sendRedirect("success.jsp");
            }
            else
            {
                response.sendRedirect("failed.jsp");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }


}


