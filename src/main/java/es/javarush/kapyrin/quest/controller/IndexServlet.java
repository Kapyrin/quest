package es.javarush.kapyrin.quest.controller;

import es.javarush.kapyrin.quest.repository.MessageFromFile;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "indexServlet", value = "")
public class IndexServlet extends HttpServlet {
    private static final String WELCOME_MESSAGE_PATH = "javaquest/welcome.txt";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String welcomeMessage = new MessageFromFile(WELCOME_MESSAGE_PATH).getMessage();

        request.setAttribute("welcomeMessage", welcomeMessage);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}