package com.sergax.crudrestapi.servlet;

import com.google.gson.Gson;
import com.sergax.crudrestapi.model.User;
import com.sergax.crudrestapi.service.serviceImplementation.UserServiceImplementation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private final UserServiceImplementation userServiceImplementation =
            new UserServiceImplementation();
//    private final Gson gson = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> userList = userServiceImplementation.getAll();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(userList);
        //Calling flush() on the PrintWriter commits the response.
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newName = request.getParameter("user_name");
//        String newPassword = request.getParameter("password");
        User newUser = new User(null, newName, new ArrayList<>());
        userServiceImplementation.create(newUser);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(newUser);
        out.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String updatedName = request.getParameter("user_name");
        String updatedPassword = request.getParameter("password");
        User updatedUser = new User(id, updatedName, new ArrayList<>());
        userServiceImplementation.update(updatedUser);
        response.sendRedirect("/user");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        userServiceImplementation.delete(id);
        response.sendRedirect("/user");
    }
}
