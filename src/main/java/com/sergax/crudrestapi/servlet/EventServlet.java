package com.sergax.crudrestapi.servlet;

import com.sergax.crudrestapi.model.Event;
import com.sergax.crudrestapi.model.File;
import com.sergax.crudrestapi.model.User;
import com.sergax.crudrestapi.service.serviceImplementation.EventServiceImplementation;
import com.sergax.crudrestapi.service.serviceImplementation.FileServiceImplementation;
import com.sergax.crudrestapi.service.serviceImplementation.UserServiceImplementation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EventServlet", urlPatterns = "/event")
public class EventServlet extends HttpServlet {
    private final EventServiceImplementation eventServiceImplementation =
            new EventServiceImplementation();
    private final UserServiceImplementation userServiceImplementation =
            new UserServiceImplementation();
    private final FileServiceImplementation fileServiceImplementation =
            new FileServiceImplementation();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Event> eventList = eventServiceImplementation.getAll();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(eventList);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newName = request.getParameter("event_name");
        Event newEvent = new Event(newName, new User(), new File());
        eventServiceImplementation.create(newEvent);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(newEvent);
        out.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String updatedName = request.getParameter("event_name");
        Long user_id = Long.valueOf(request.getParameter("user_id"));
        Long file_id = Long.valueOf(request.getParameter("file_id"));
        User newUser = userServiceImplementation.getById(user_id);
        File newFile = fileServiceImplementation.getById(file_id);
        Event updatedEvent = new Event(id, updatedName, newUser, newFile);
        eventServiceImplementation.update(updatedEvent);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        eventServiceImplementation.delete(id);
    }
}
