<%@ page import="java.sql.*"%>
<%@ page import="com.r3sys.reminderdb.*"%>

<%
Connection con = ConnectDB.connect();

PreparedStatement ps = con.prepareStatement(
"SELECT * FROM remainders WHERE uemail=?");

ps.setString(1, GetSet.getUemail());

ResultSet rs = ps.executeQuery();
%>

<table border="1">

<tr>
<th>RID</th>
<th>TITLE</th>
<th>DESCRIPTION</th>
<th>DATE</th>
<th>DELETE</th>
</tr>

<%
while(rs.next())
{
%>

<tr>

<td><%=rs.getInt("rid")%></td>

<td><%=rs.getString("rtitle")%></td>

<td><%=rs.getString("rdese")%></td>

<td><%=rs.getString("rdate")%></td>




<td>
    <form action="DeleteReminderServlet" method="post">
        <input type="hidden" name="rid" value="<%=rs.getInt("rid")%>">
        <input type="submit" value="Delete">
    </form>



</td>

</tr>

<%
}
%>

</table>

<a href="home.jsp">Home</a>