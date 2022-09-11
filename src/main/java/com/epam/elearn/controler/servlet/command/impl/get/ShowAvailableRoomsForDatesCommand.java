package com.epam.elearn.controler.servlet.command.impl.get;

import com.epam.elearn.controler.servlet.command.FrontCommand;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.entity.RoomCategory;
import com.epam.elearn.service.RoomService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowAvailableRoomsForDatesCommand implements FrontCommand {
    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws DBException, IOException, ServletException {
        String arrivingDate = request.getParameter("startDate");
        String leavingDate = request.getParameter("endDate");
        String guestsInRooms = request.getParameter("guestsInRooms");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < guestsInRooms.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(guestsInRooms.charAt(i))));
        }
        System.out.println(list);

        Map<RoomCategory, Integer> result = new RoomService().roomTest(LocalDate.parse(arrivingDate), LocalDate.parse(leavingDate), list);

        request.setAttribute("map", result);

        request.getRequestDispatcher("WEB-INF/views/RoomSearcherPage.jsp").forward(request, response);
    }
}
