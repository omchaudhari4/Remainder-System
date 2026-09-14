<%@ page import="com.r3sys.reminderdb.GetSet" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Welcome</h2>

<h3><%=GetSet.getUemail()%></h3>

<hr>

<a href="addReminder.jsp">Add Reminder</a>

<br><br>

<a href="viewReminder.jsp">View All Reminder</a>

<br><br>

<a href="todayReminder.jsp">Today's Reminder</a>

<br><br>

<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>