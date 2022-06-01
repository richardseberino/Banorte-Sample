<%@page import="com.banorte.sample.dto.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="com.banorte.sample.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Clients</title>
</head>
<body>
<h1>List of Clients</h1>

<table border=1>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>e-mail</th>
	</tr>
	<%
	
	DBConnection con = new DBConnection();
	List<Cliente> clients = con.getClientList();
	for (int x =0; x < clients.size(); x++)
	{
		%>
		<tr>
			<td><%=clients.get(x).getId() %></td>
			<td><%=clients.get(x).getName()%></td>
			<td><%=clients.get(x).getEmail() %></td>
		<%
	}
	
	%>

</table>



<br /><br />
<a href="index.html">Back to menu</a>
</body>
</html>