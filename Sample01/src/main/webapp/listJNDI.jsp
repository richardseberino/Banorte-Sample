<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.NameClassPair"%>
<%@page import="javax.naming.NamingEnumeration"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
InitialContext ctx = new InitialContext();
//Context ctx2 = (Context) ctx.lookup("");
NamingEnumeration<NameClassPair> list = ctx.list("");
while (list.hasMore()) {
  System.out.println(list.next().getName());
}

%>
</body>
</html>