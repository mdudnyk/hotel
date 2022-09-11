<%@ page import="com.epam.elearn.entity.RoomCategory" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="ua">
<head>
    <title>Air Hotel</title>
    <meta  name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/air-small-icon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/room_searcher.css">
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
</head>
<body>
<%@ include file="fragments/Header.jspf" %>

<div class="content__datepicker_block">
    <form action="controller" method="get">
        <div class="content__search-form">
            <div class="content__hidden-form">
                <input type="hidden" name="cmd" value="SHOW_AVAILABLE_ROOMS_FOR_DATES" readonly />
            </div>
            <div class="content__start-date">
                <input type="text" class="content__start-date-field" name="startDate" placeholder="Arriving Date" required/>
            </div>
            <div class="content__end-date">
                <input type="text" class="content__end-date-field" name="endDate" placeholder="Leaving Date" required/>
            </div>
            <div class="content__rooms-guests">
                <input type="text" id="guests_filed" class="content__rooms-guests-field"  placeholder="Guests amount" readonly/>
                <div id="myDropdown" class="dropdown-content">
                    <div id="wrapper">
                        <div id="room_content">
                            <!-- room rows inserted from javascript -->
                        </div>
                        <div id="btn_content">
                            <button id="add_room_btn" type="button">Add room</button>
                            <button id="done_btn" type="button">Done</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="guests_filed_hidden">
                <input type="hidden" id="guests_filed_hidden" name="guestsInRooms" readonly />
            </div>
            <div class="content__search">
                <button id="srch_btn" class="content__search-button" type="button">Search</button>
            </div>
        </div>
    </form>
</div>

<div class="categories_block">
    <%
        Map<RoomCategory, Integer> map = (Map<RoomCategory, Integer>) request.getAttribute("map");
        if (map != null && map.size() != 0) {
            for(RoomCategory category: map.keySet()) {
    %>
    <div class="categories_block__row">
        <img src="img/rooms_images/double_room.jpg" class="image" alt="Double room" height="210px">
        <div class="categories_block_def_module">
            <span id="category_title_1"> <%=category.getTitle()%> </span>
            <span id="category_title_5">
                <%
                    int rooms = map.get(category);
                    if (rooms <= 3) {
                        if (rooms == 1) {
                            out.print("Only 1 room available!");
                        } else {
                            out.print("Only " + rooms + " rooms available!");
                        }
                    }
                %>
            </span>
            <div>
                <p id="category_title_2">Area: <%=category.getArea()%> m<span id="square_meter">2</span></p>
                <p id="category_title_3">Max persons: <%=category.getGuestsCapacity()%></p>
            </div>
            <span id="category_title_4">Read more</span>
        </div>
    </div>
    <%
            }
        }
    %>
</div>

<%@ include file="fragments/Footer.jspf" %>
<script src="${pageContext.request.contextPath}/js/flatpickr_2.js"></script>
</body>
</html>
