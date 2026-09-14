<%@page import="java.sql.*"%>
<%@page import="com.r3sys.reminderdb.*"%>

<%
Connection con = ConnectDB.connect();

PreparedStatement ps = con.prepareStatement(
"select * from remainders where uemail=? and rdate=CURDATE()");

ps.setString(1, GetSet.getUemail());

ResultSet rs = ps.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Today's Reminder</title>
</head>
<body>

<h2>Today's Reminder</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Title</th>
<th>Description</th>
<th>Date</th>
</tr>

<%
while(rs.next())
{
%>

<tr>

<td><%=rs.getInt("rid")%></td>

<td><%=rs.getString("rtitle")%></td>

<td><%=rs.getString("rdese")%></td>

<td><%=rs.getDate("rdate")%></td>

</tr>

<%
}
%>

</table>

<br>

<a href="home.jsp">Home</a>

</body>
</html>