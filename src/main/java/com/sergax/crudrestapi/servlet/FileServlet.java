package com.sergax.crudrestapi.servlet;

import com.sergax.crudrestapi.model.File;
import com.sergax.crudrestapi.service.serviceImplementation.FileServiceImplementation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "FileServlet", urlPatterns = "/file")
public class FileServlet extends HttpServlet {
    private FileServiceImplementation fileServiceImplementation =
            new FileServiceImplementation();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<File> fileList = fileServiceImplementation.getAll();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(fileList);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newFileName = request.getParameter("file_name");
        LocalDate date = LocalDate.now();
        File newFile = new File(newFileName);
        fileServiceImplementation.create(newFile);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(newFile);
        out.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String updatedName = request.getParameter("file_name");
        LocalDate date = LocalDate.now();
        File updatedFile = new File(id, updatedName);
        fileServiceImplementation.update(updatedFile);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        fileServiceImplementation.delete(id);
    }
}
