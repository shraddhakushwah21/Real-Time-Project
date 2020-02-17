<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	
	<h2><u> Contact Info </u></h2>
	<h3 style="color: green;"> ${sucMsg}</h3>
	<h3 style="color: red;"> ${errMsg}</h3>
	<form:form action="addContact?contactId=${contact.contactId}" method="POST" modelAttribute="contact">
		<table>
			<tr>
				<td>Name : </td>
				<td><form:input path="contactName" /></td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><form:input path="contactEmail" /></td>
			</tr>
			<tr>
				<td>Phone : </td>
				<td><form:input path="contactNumber"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"/></td>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</table>
	</form:form>
	<a href="viewContacts"> View All Contacts </a>
</center>
</body>
</html>