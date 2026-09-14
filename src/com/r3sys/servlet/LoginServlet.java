package com.r3sys.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.reminderdb.ConnectDB;
import com.r3sys.reminderdb.GetSet;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String uemail = request.getParameter("uemail");
        String upassword = request.getParameter("upassword");

        try {

            Connection con = ConnectDB.connect();

            PreparedStatement ps = con.prepareStatement(
            "select * from user where uemail=? and upassword=?");

            ps.setString(1, uemail);
            ps.setString(2, upassword);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                GetSet.setUemail(uemail);

                response.sendRedirect("home.jsp");
            }
            else
            {
                response.sendRedirect("failed.jsp");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


	}


