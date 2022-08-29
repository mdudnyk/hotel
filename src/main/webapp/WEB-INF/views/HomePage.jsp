<!DOCTYPE html>
    <html lang="ua">
    <head>
        <meta charset = "UTF-8" />
        <title>Welcome | Air Hotel</title>
        <meta  name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/air-small-icon.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

    </head>
<body>

<header class="header">
    <div class="header__row">
        <div class="header__logo">
            <img src="${pageContext.request.contextPath}/img/airhotel-logo-dark.svg" alt="Air Hotel" width="auto" height="80px">
        </div>
        <button class="header__sing-in-btn" onclick="document.getElementById('id01').style.display='block'">Sign in</button>


        <div id="id01" class="modal">
            <span onclick="closeModal()" class="close" title="Close Modal">&#x2715</span>
            <div class="modal__content">
                <form class="modal__signin-form">
                    <div>
                        <div><label id="id02" class="modal__email-label">email:</label></div>
                        <input type="text" id="id03" class="modal__email-input" name="email" placeholder="Enter your email" required/>
                    </div>
                    <div>
                        <div><label id="id04" class="modal__password-label">password:</label></div>
                        <input type="password" id="id05" class="modal__password-input" name="password" placeholder="Enter your password" required/>
                    </div>
                    <div>
                        <button type="button" id="id06" class="modal__sign-in-btn"  >Sign in</button>
                    </div>
                </form>
            </div>
        </div>



    </div>
</header>

<div class="under-header-line"></div>

<div class="content">
    <div class="content__datepicker">
        <p class="content__welcome">Welcome to our booking system</p>
        <p class="content__please">select dates when you are going to visit us</p>
        <form action="controller" method="get">
            <div class="content__search-form">
                <div class="content__hidden-form">
                    <input type="hidden" name="cmd" value="CATEGORY_PAGE" readonly />
                </div>
                <div class="content__start-date">
                    <input type="text" class="content__start-date-field" name="startDate" placeholder="Arriving Date" required/>
                </div>                        <div class="content__end-date">
                <input type="text" class="content__end-date-field" name="endDate" placeholder="Leaving Date" required/>
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

<script src="${pageContext.request.contextPath}/js/flatpickr.js"></script>
<script src="${pageContext.request.contextPath}/js/sign_in_modal.js"></script>

</body>
</html>
