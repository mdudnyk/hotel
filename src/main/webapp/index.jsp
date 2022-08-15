<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log in</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%--<div class="container mt-5 border">--%>
<%--    <h2>Lets start</h2>--%>
<%--    <form action="/logIn-servlet">--%>
<%--        <div class="mb-3 mt-3">--%>
<%--            <label for="login" class="form-label">Login:</label>--%>
<%--            <input type="login" class="form-control" id="login" placeholder="Enter login" name="login">--%>
<%--        </div>--%>
<%--        <div class="mb-3">--%>
<%--            <label for="pwd" class="form-label">Password:</label>--%>
<%--            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">--%>
<%--        </div>--%>
<%--        <button type="submit" class="btn btn-primary">Submit</button>--%>
<%--    </form>--%>
<%--</div>--%>

<section class="vh-100">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form method="post" action="/logIn-servlet">
                    <!-- Email input -->
                    <div class="mb-3 mt-3">
                        <input type="email" id="email" class="form-control form-control-lg" placeholder="Enter email" name="email">
                    </div>
                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <input type="password" id="form3Example4" class="form-control form-control-lg" placeholder="Enter password"/>
                    </div>
                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-primary">Log in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div
            class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
        <!-- Copyright -->
        <div class="text-white mb-3 mb-md-0">
            Created by mdudnyk in 2022
        </div>
        <!-- Copyright -->

    </div>
</section>

</body>
</html>