<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello !!! ${name}</h1>
<form action="saveemp" method="post" >
<label>Name :</label>
<input type="text" name="name" placeholder="enter name..."></br>
<label>Address :</label>
<input type="text"  name="address" placeholder="enter address.."></br>
<input type="submit" value="SaveEmp"></input>
</form>
</body>
</html>