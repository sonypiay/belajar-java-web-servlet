package programmer_zaman_now.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/todolist")
public class TodolistServlet extends HttpServlet {

    private List<String> todolist = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(todolist);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todo = req.getParameter("todo");

        if( todo != null ) {
            todolist.add(todo);

            resp.getWriter().println("Add todo: " + todo);
        } else {
            resp.getWriter().println("Todo parameter must exists!");
        }
    }
}
