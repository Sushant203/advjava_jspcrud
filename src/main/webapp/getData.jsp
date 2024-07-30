<%@ page import="java.util.List" %>
<%@ page import="com.crud.java.UserData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Database Data</title>
    <style>
        table, th, td {
            border: 1px solid black;
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            width: 1000px;
            
        }
        h1 {
            text-align: center;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: red;
        }
        div {
            display: flex;
        }
        button {
            margin-left: 10px;
        }
    </style>
</head>
<body>
<h1>The Database Data</h1>
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${userList}" var="userdata">
            <tr>
                <td><c:out value="${userdata.id}"/></td>
                <td><c:out value="${userdata.name}"/></td>
                <td><c:out value="${userdata.age}"/></td>
                <td><c:out value="${userdata.address}"/></td>
                <td style="display: flex; justify-content: center; align-items: center; width: 100px;">
                    <div>
                        <form action="DeleteServlet" method="post">
                            <input type="hidden" name="id" value="${userdata.id}">
                            <input type="submit" value="Delete">
                        </form>
                        <form action="UpdateData" method="get">
                         <input type="hidden" name="id" value="${userdata.id}">
                        
                             <input type="submit" value="Update">
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="index.jsp">Insert Data</a>
</body>
</html>