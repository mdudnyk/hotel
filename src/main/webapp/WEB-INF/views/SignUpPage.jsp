<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="ua">
<head>
    <title>Welcome | Air Hotel</title>
    <meta  name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/air-small-icon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sign_up.css">
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
</head>
<body>
<%@ include file="fragments/Header.jspf" %>

<div class="content">
    <div id="text_block_s_u">
        <p id="text_01_s_u">Please fill all fields</p>
        <p id="text_02_s_u">to complete the process of registration</p>
    </div>
    <div id="alert_block_s_u">
        <p id="text_alert_s_u">Alert message</p>
    </div>
    <div id="input_block_s_u">
        <span id="name_text_s_u">Name:</span>
        <input type="text" id="name_field_s_u" placeholder="Enter your name">
        <span id="surname_text_s_u">Surname:</span>
        <input type="text" id="surname_field_s_u" placeholder="Enter your surname">
        <span id="email_text_s_u">Email:</span>
        <input type="text" id="email_field_s_u" placeholder="Enter your email">
        <span id="password_text_s_u">Password:</span>
        <input type="password" id="password_field_s_u" placeholder="Enter your password">
        <span id="password_repeat_text_s_u">Password:</span>
        <input type="password" id="password_repeat_field_s_u" placeholder="Repeat your password">
        <button type="button" id="btn_s_u">Sign up</button>
    </div>
</div>

<%@ include file="fragments/Footer.jspf" %>
<script src="${pageContext.request.contextPath}/js/sign_up.js"></script>
</body>
</html>