<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>
<style type="text/css">
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<form:form modelAttribute="user" action="validateForm" method="POST">
		<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>
		<br>
		<label>Enter User Name </label>
		<br>
		<br>
		<form:input path="userName" />
		<form:errors path="userName" cssClass="errorblock" element="div" />
		<br>
		<br>
		<label>Enter Email </label>
		<br>
		<br>
		<form:input path="userSkill" />
		<form:errors path="userSkill" cssClass="errorblock" element="div" />
		<br>
		<br>
		<input type="submit" value="Register">
		<br>
	</form:form>
</body>
</html>