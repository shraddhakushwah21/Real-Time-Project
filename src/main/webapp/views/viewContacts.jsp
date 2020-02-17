<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">

	function confirmDelete(){
		return confirm("Are you sure you want to delete this contact ?");
		}
</script>
<title>Insert title here</title>
</head>
<body>
<center>
	<h2 style="color: fuchsia;"><u> View All Contacts</u></h2>
	<a href="loadContact"> + Add New Contact</a>
	<br><br>
	
	<table border="1" >
		<thead>
			<tr>
				<td>Contact Id</td>
				<td>Contact Name</td>
				<td>Contact Email</td>
				<td>Contact Number</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="contact">
				<tr>
					<td>${contact.contactId}</td>
					<td>${contact.contactName}</td>
					<td>${contact.contactEmail}</td>
					<td>${contact.contactNumber}</td>
					<td>
						<a href="editContact?contactId=${contact.contactId}"> Edit</a>
						<a href="deleteContact?contactId=${contact.contactId}" onclick=" return confirmDelete()"> Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<font color="green"> ${succMsg}</font>
	<font color="red"> ${failMsg}</font>
</center>
</body>
</html>