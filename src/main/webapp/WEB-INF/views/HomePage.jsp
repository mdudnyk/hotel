<!DOCTYPE html>
    <html lang="ua">
    <head>
        <title>Welcome | Air Hotel</title>
        <meta  name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/air-small-icon.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
        <meta charset="UTF-8">
    </head>
<body>

<header class="header">
    <div class="header__row">
        <div class="header__logo">
            <img src="${pageContext.request.contextPath}/img/airhotel-logo-dark.svg" alt="Air Hotel" width="auto" height="80px">
        </div>
        <div class="header__sign-in-button">
            <form class="header__form-for-btn" action="controller">
                <input type="hidden" name="cmd" value="SIGN_IN_PAGE" readonly>
                <input class="header__sing-in-btn" type="submit" value="Sign in">
            </form>
        </div>
    </div>
</header>

<div class="under-header-line"></div>

<div class="wrapper">

    <div class="content">
        <div class="content__row">
            <div class="content__main-text">
                <p class="content__welcome">Welcome to our booking system</p>
                <p class="content__please">select dates when you are going to visit us</p>
            </div>
        </div>
        <div class="content__row">
            <form action="controller" autocomplete="off">
                <div class="content__search-form">
                    <div class="content__hidden-form">
                        <input type="hidden" name="cmd" value="CATEGORY_PAGE" readonly/>
                    </div>
                    <div class="content__start-date">
                        <input type="text" class="content__start-date-field" name="startDate" placeholder="Arriving Date" readonly/>
                    </div>
                    <div class="content__end-date">
                        <input type="text" class="content__end-date-field" name="endDate" placeholder="Leaving Date" readonly/>
                    </div>
                    <div class="content__search">
                        <button class="content__search-button" type="submit">Search</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <footer class="footer">
        <div class="footer__row">
            <div class="footer__create-by-text">Created by mdundyk 2022</div>
            <div class="footer__air-hotel-text">Air Hotel</div>
        </div>
    </footer>

</div>

<script src="${pageContext.request.contextPath}/js/flatpickr.js"></script>

</body>
</html>
