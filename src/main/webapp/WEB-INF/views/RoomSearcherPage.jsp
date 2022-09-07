<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="ua">
<head>
    <title>Air Hotel</title>
    <meta  name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/air-small-icon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/roomsearcher.css">
</head>
<body>
<%@ include file="fragments/Header.jspf" %>

<div class="content">
    <div class="content__show-date">
        <p>
            The start date is <%= request.getParameter("startDate") %>
            The end date is <%= request.getParameter("endDate") %>

        </p>
    </div>
</div>


<%@ include file="fragments/Footer.jspf" %>
</body>
</html>
