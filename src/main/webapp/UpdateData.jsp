<%@ page import="com.crud.java.UserData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <style>
        form {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid black;
            text-align: center;
        }
        div {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<h1>Update userListData</h1>
 <c:forEach items="${userList}" var="userdata">
<form action="UpdateServlet" method="post">

   Id: <input type="text" name="id" value="${userdata.id}" readonly="readonly">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${userdata.name}">
    </div>
    <div>
        <label for="age">Age:</label>
        <input type="text" id="age" name="age" value="${userdata.age}">
    </div>
    <div>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${userdata.address}">
    </div>
   
    <div>
        <input type="submit" value="Update">
    </div>
</form>
</c:forEach>
</body>
</html>