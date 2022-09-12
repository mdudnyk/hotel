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

import static java.time.temporal.ChronoUnit.DAYS;

public class ShowAvailableRoomsForDatesCommand implements FrontCommand {
    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response)
            throws DBException, IOException, ServletException {
        String arrivingDate = request.getParameter("startDate");
        String leavingDate = request.getParameter("endDate");
        String guestsInRooms = request.getParameter("guestsInRooms");

        if (arrivingDate != null && leavingDate != null && guestsInRooms != null) {
            List<Integer> guestsList = new ArrayList<>();

            for (int i = 0; i < guestsInRooms.length(); i++) {
                guestsList.add(Integer.parseInt(String.valueOf(guestsInRooms.charAt(i))));
            }

            LocalDate arrivingOn = LocalDate.parse(arrivingDate);
            LocalDate leavingOn = LocalDate.parse(leavingDate);

            Map<RoomCategory, Integer> result = new RoomService().roomTest(arrivingOn, leavingOn, guestsList);
            request.setAttribute("map", result);

            long nights = DAYS.between(arrivingOn, leavingOn);
            request.setAttribute("nights", nights);
        }

        request.getRequestDispatcher("WEB-INF/views/RoomSearcherPage.jsp").forward(request, response);
    }
}
