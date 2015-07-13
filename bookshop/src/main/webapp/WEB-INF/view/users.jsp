<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping</title>
<link rel="stylesheet" href="<c:url value='/assets/style.css' />" type="text/css" media="all">
</head>
<body>
  <div id="layout-one-fixed">
    <div id="container">
      <div id="header">
        <h1>Users</h1>
      </div>
      <div id="navigation">
        <ul>
          <li><a href="<c:url value='/' />">Home</a></li>
          <li><a href="<c:url value='/shopping.html' />">Bookstore</a></li>
          <li><a href="<c:url value='/users.html' />">Users</a></li>
        </ul>
      </div>
      <div id="content">
      	<form action="<c:url value='/users.html' />"  method="get">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" value="${listUsersRequest.name}"/>
            <label for="email">Email</label>
            <input type="text" id="email" name="email" value="${listUsersRequest.email}"/>
            
        	<button type="submit">Search</button>
        </form>
      
        <table>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>pwd</th>
          </tr>

          <c:forEach var="users" items="${listUsersModel.users}">
            <tr>
              <td>${users.name}</td>
              <td>${users.email}</td>
              <td>${users.password}</td>
            </tr>
          </c:forEach>

        </table>
      </div>
    </div>
  </div>
</body>
</html>
