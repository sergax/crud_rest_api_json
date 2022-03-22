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
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private final UserServiceImplementation userServiceImplementation =
            new UserServiceImplementation();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/HTML; charset=UTF-8");
        List<User> userList = userServiceImplementation.getAll();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
        out.write(gson.toJson(userList));
//        out.print(userList);
        //Calling flush() on the PrintWriter commits the response.
//        out.flush();
//        response.sendRedirect("/user");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newName = request.getParameter("newName");
        String newPassword = request.getParameter("newPassword");
        User newUser = new User(newName);
        userServiceImplementation.create(newUser);
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/HTML; charset=UTF-8");
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        out.print(newUser);
//        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String updatedName = request.getParameter("updatedName");
        User updatedUser = new User(id, updatedName);
        userServiceImplementation.update(updatedUser);
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/HTML; charset=UTF-8");
//        out.write(gson.toJson(updatedUser.toString()));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        userServiceImplementation.delete(id);
        PrintWriter out = response.getWriter();
        out.write(gson.toJson("User was deleted " + id));
    }
}
