<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="<c:url value="assets/style.css" />" type="text/css" media="all">
</head>
<body>
  <div id="layout-one-fixed">
    <div id="container">
      <div id="header">
        <h1>Add new book</h1>
      </div>
      <div id="navigation">
        <ul>
          <li><a href="<c:url value='/' />">Home</a></li>
          <li><a href="<c:url value='/shopping.html' />">Bookstore</a></li>
          <li><a href="<c:url value='/addBookForm.html' />">Manage books</a></li>
          <li><a href="<c:url value='/users.html' />">Users</a></li>
          <li><a href="<c:url value='/addUserForm.html' />">Manage Users</a></li>
        </ul>
      </div>
      <div id="content">
        <c:if test="${not empty message}">
          <div class="alert alert-success">${message}</div>
        </c:if>
        <form:form modelAttribute="addUserRequest" action="addUserPost.html">
          <div class="form-group">
            <p>
              <label for="input_name">Name</label>
              <form:input path="name" id="input_name" class="form-control" placeholder="Name" />
            </p>
            <p>
              <label for="input_email">Email</label>
              <form:input path="email" id="input_email" class="form-control" placeholder="Email" />
            </p>
            <p>
              <label for="input_password">Password</label>
              <form:input path="password" type="password" id="input_password" class="form-control" placeholder="Password" />
            </p>
            <p>
              <label for="input_passwordConfirm">Password again</label>
              <form:input path="passwordConfirm" type="password" id="input_passwordConfirm" class="form-control" placeholder="Password confirm" />
            </p>
          </div>
          <p>
            <button type="submit" class="btn btn-default">Add</button>
          </p>
        </form:form>
      </div>
    </div>
  </div>
</body>
</html>