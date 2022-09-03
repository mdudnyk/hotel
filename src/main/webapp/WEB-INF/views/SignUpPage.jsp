<%@ page contentType="text/html; charset=UTF-8"
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
    <div id="succs_registr__s_u">
        <p id="text_00_s_u"><fmt:message key="sign_up.successful"/>
            <a id="sign_in_text_s_u"><fmt:message key="sign_up.sign_in"/></a>
            <fmt:message key="sign_up.continue"/></p>
    </div>
    <div id="text_block_s_u">
        <p id="text_01_s_u"><fmt:message key="sign_up.fill_fields"/></p>
        <p id="text_02_s_u"><fmt:message key="sign_up.to_complete"/></p>
    </div>
    <div id="alert_block_s_u">
        <p id="text_alert_s_u"></p>
    </div>
    <div id="input_block_s_u">
        <span id="name_text_s_u"><fmt:message key="sign_up.name"/></span>
        <span id="name_text_s_u_invalid"><fmt:message key="sign_up.name_invalid"/></span>
        <input type="text" id="name_field_s_u"
               placeholder="<fmt:message key="sign_up.name_placeholder"/>">

        <span id="surname_text_s_u"><fmt:message key="sign_up.surname"/></span>
        <span id="surname_text_s_u_invalid"><fmt:message key="sign_up.surname_invalid"/></span>
        <input type="text" id="surname_field_s_u"
               placeholder="<fmt:message key="sign_up.surname_placeholder"/>">

        <span id="email_text_s_u"><fmt:message key="sign_up.email"/></span>
        <span id="email_text_s_u_invalid"><fmt:message key="sign_up.email_invalid"/></span>
        <input type="text" id="email_field_s_u"
               placeholder="<fmt:message key="sign_up.email_placeholder"/>">

        <span id="password_text_s_u"><fmt:message key="sign_up.password"/></span>
        <span id="password_text_s_u_invalid"><fmt:message key="sign_up.password_invalid"/></span>
        <input type="password" id="password_field_s_u"
               placeholder="<fmt:message key="sign_up.password_placeholder"/>">

        <span id="password_repeat_text_s_u"><fmt:message key="sign_up.password"/></span>
        <span id="password_repeat_text_s_u_invalid"><fmt:message key="sign_up.password_invalid"/></span>
        <span id="password_repeat_text_s_u_not_repeat"><fmt:message key="sign_up.password_should_repeat"/></span>
        <input type="password" id="password_repeat_field_s_u"
               placeholder="<fmt:message key="sign_up.password_repeat_placeholder"/>">
        <button type="button" id="btn_s_u"><fmt:message key="sign_up.sign_up_btn"/></button>
    </div>
</div>

<%@ include file="fragments/Footer.jspf" %>
<script src="${pageContext.request.contextPath}/js/sign_up.js"></script>
</body>
</html>