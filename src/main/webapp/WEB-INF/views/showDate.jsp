<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Showing date</title>
</head>
<body>
<p>
    The start date is <%= request.getParameter("startDate") %>
    The end date is <%= request.getParameter("endDate") %>
</p>
</body>
</html>
