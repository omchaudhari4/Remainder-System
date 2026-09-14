<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Reminder</title>
</head>
<body>

<h2>Add Reminder</h2>

<form action="AddReminderServlet" method="post">

Reminder ID
<input type="number" name="rid" required>

<br><br>

Reminder Title
<input type="text" name="rtitle" required>

<br><br>

Reminder Description
<textarea name="rdese" rows="5" cols="30" required></textarea>

<br><br>

Reminder Date
<input type="date" name="rdate" required>

<br><br>

<input type="submit" value="Save Reminder">

</form>


<a href="home.jsp">Home</a>
</body>
</html>