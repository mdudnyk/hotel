package com.epam.elearn.controler.servlet.command.impl.get;

import com.epam.elearn.controler.servlet.command.FrontCommand;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.service.RoomService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShowAvailableRoomsForDatesCommand implements FrontCommand {
    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws DBException, IOException, ServletException {

        String arrivingDate = request.getParameter("startDate");
        String leavingDate = request.getParameter("endDate");

        System.out.println("START DAY - " + arrivingDate);
        System.out.println("END DAY - " + leavingDate);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);


        new RoomService().roomTest(LocalDate.parse(arrivingDate), LocalDate.parse(leavingDate), list);

        request.getRequestDispatcher("WEB-INF/views/RoomSearcherPage.jsp").forward(request, response);
    }
}
