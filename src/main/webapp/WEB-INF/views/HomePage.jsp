<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="${sessionScope.lang == null ? 'en' : sessionScope.lang}">

<head>
    <title>Welcome | Air Hotel</title>
    <meta  name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/air-small-icon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
</head>
<body>
<%@ include file="fragments/Header.jspf" %>

<div class="content">
    <div class="content__datepicker">
        <p class="content__welcome"> <fmt:message key="home.welcome"/> </p>
        <p class="content__please"> <fmt:message key="home.select_dates"/> </p>
        <form action="controller" method="get">
            <div class="content__search-form">
                <div class="content__hidden-form">
                    <input type="hidden" name="cmd" value="ROOM_SEARCHER_PAGE" readonly />
                </div>
                <div class="content__start-date">
                    <input type="text" class="content__start-date-field" name="startDate" placeholder="<fmt:message key="home.arriving"/>" required/>
                </div>                        <div class="content__end-date">
                <input type="text" class="content__end-date-field" name="endDate" placeholder="<fmt:message key="home.leaving"/>" required/>
            </div>
                <div class="content__search">
                    <button class="content__search-button" type="submit"> <fmt:message key="home.search"/> </button>
                </div>
            </div>
        </form>
    </div>
</div>

<%@ include file="fragments/Footer.jspf" %>
<script src="${pageContext.request.contextPath}/js/flatpickr.js"></script>
</body>
</html>
