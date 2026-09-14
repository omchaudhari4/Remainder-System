package com.r3sys.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.reminderdb.ConnectDB;
import com.r3sys.reminderdb.GetSet;

public class AddReminderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddReminderServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Optional: redirect if someone accesses the servlet directly
        response.sendRedirect("addReminder.jsp");
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        int rid = Integer.parseInt(request.getParameter("rid"));
        String rtitle = request.getParameter("rtitle");
        String rdese = request.getParameter("rdese");
        String uemail = GetSet.getUemail();
        String rdate = request.getParameter("rdate");

        try {

            Connection con = ConnectDB.connect();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO remainders(rid,rtitle,rdese,uemail,rdate) VALUES(?,?,?,?,?)");

            ps.setInt(1, rid);
            ps.setString(2, rtitle);
            ps.setString(3, rdese);
            ps.setString(4, uemail);
            ps.setString(5, rdate);

            int i = ps.executeUpdate();

            if (i > 0) {
                response.sendRedirect("viewReminder.jsp");
            } else {
                response.sendRedirect("failed.jsp");
            }

        } catch (Exception e) {

            System.out.println("Reminder Not Saved");
            e.printStackTrace();

        }
    }
}