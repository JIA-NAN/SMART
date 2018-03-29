<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="loginPage"></s:text></title>
</head>
<body>
<s:form action="login">
	<s:textfield name="username" key="user name"/>
	<s:textfield name="password" key="password"/>
	<s:submit key="login" />
</s:form>
</body>
</html>