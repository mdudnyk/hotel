<%@ page import="com.epam.elearn.dao.FactoryDao" %>
<%@ page import="com.epam.elearn.dao.RoomCategoryDao" %>
<%@ page import="com.epam.elearn.dao.DBException" %>
<%@ page import="com.epam.elearn.entity.RoomCategory" %>
<%@ page import="java.util.List" %>

<HTML>
<HEAD>
    <TITLE>Select Data From a Database</TITLE>
</HEAD>
<BODY BGCOLOR="cyan">
<H1>Select Data From a Database</H1>
<%
    FactoryDao dao = FactoryDao.create("MYSQL");
    RoomCategoryDao rcDao = dao.getRoomCategoryDao();
    List<RoomCategory> list = null;

    try {
        list = rcDao.getAll();
    } catch (DBException e) {
        e.printStackTrace();
    }
%>
<TABLE BORDER="1">
    <TR>
        <TH>ID</TH>
        <TH>TITLE</TH>
        <TH>PRICE</TH>
        <TH>AREA</TH>
        <TH>GUESTS</TH>
        <TH>DESCRIPTION</TH>
    </TR>
    <%if (list != null) {
            for (RoomCategory rc : list) {%>
    <TR>
        <TD><%= rc.id() %>
        </td>
        <TD><%= rc.title() %>
        </TD>
        <TD><%= rc.priceDefault() %>
        </TD>
        <TD><%= rc.area() %>
        </TD>
        <TD><%= rc.guestsCapacity() %>
        </TD>
        <TD><%= rc.description() %>
        </td>
    </TR>
    <%}}%>
</TABLE>
</BODY>
</HTML>
