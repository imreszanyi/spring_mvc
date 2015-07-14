<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book details</title>
<link rel="stylesheet" href="<c:url value='/assets/style.css' />" type="text/css" media="all">
</head>
<body>
  <div id="layout-one-fixed">
    <div id="container">
      <div id="header">
        <h1>Buy our book</h1>
      </div>
      <div id="navigation">
        <ul>
          <li><a href="<c:url value='/' />">Home</a></li>
          <li><a href="<c:url value='/shopping.html' />">Bookstore</a></li>
          <li><a href="<c:url value='/addBookForm.html' />">Manage books</a></li>
          <li><a href="<c:url value='/users.html' />">Users</a></li>
          <li><a href="<c:url value='/addUserForm.html' />">Users</a></li>
        </ul>
      </div>
      <div id="content">
        <h2>Title</h2>
        <p>${bookDetailsModel.bookSummary.title}</p>
        <h2>Author</h2>
        <p>${bookDetailsModel.bookSummary.author}</p>
        <h2>Synopsis</h2>
        <p>${bookDetailsModel.bookDetails.synopsis}</p>
      </div>
    </div>
  </div>
</body>
</html>
