package es.javarush.kapyrin.quest.controller;

import es.javarush.kapyrin.quest.entity.Player;
import es.javarush.kapyrin.quest.entity.Quest;
import es.javarush.kapyrin.quest.entity.Question;
import es.javarush.kapyrin.quest.service.QuestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "javaServlet", value = "/javaServlet")
public class JavaServlet extends HttpServlet {
    private static final String QUEST_NAME = "JavaQuest";
    public static final String WON_MESSAGE_PATH = "javaquest/won.txt";
    public static final String QUESTIONS_JSON_PATH = "javaquest/javaquest.json";
    private QuestService questService;
    private String currentSession;
    private int incorrectAttempts = 0;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        QuestService questService = (QuestService) session.getAttribute("questService");
        if (questService == null) {
            questService = initializeQuestService(request, session);
        }

        String selectedAnswer = request.getParameter("answer");

        boolean isAnswerCorrect = questService.checkAnswer(selectedAnswer);

        if (selectedAnswer == null) {
            Question currentQuestion = questService.getQuestion();
            List<String> answers = questService.shuffleAnswers(currentQuestion);

            request.setAttribute("questionText", currentQuestion.getTheQuestion());
            request.setAttribute("answer1", answers.get(0));
            request.setAttribute("answer2", answers.get(1));
            request.getRequestDispatcher("/question.jsp").forward(request, response);
        } else {
            if (isAnswerCorrect) {
                if (questService.isQuestComplete()) {
                    request.setAttribute("victoryMessage", questService.getVictoryMessage());
                    request.getRequestDispatcher("/won.jsp").forward(request, response);
                } else {
                    Question currentQuestion = questService.getQuestion();
                    request.setAttribute("questionText", currentQuestion.getTheQuestion());
                    request.setAttribute("answer1", currentQuestion.getCorrectAnswer());
                    request.setAttribute("answer2", currentQuestion.getWrongAnswer());
                    request.getRequestDispatcher("/question.jsp").forward(request, response);
                }
            } else {
                session.setAttribute("lastQuestion", questService.getCurrentQuestion());
                incorrectAttempts++;
                request.setAttribute("playerName", questService.getCurrentPlayer().getNickName());
                request.setAttribute("incorrectAttempts", incorrectAttempts);
                request.getRequestDispatcher("/lost.jsp").forward(request, response);
            }

        }
    }

    private QuestService initializeQuestService(HttpServletRequest request, HttpSession session) {
        String playerName = request.getParameter("nickname");
        String currentSession = session.getId();
        Player currentPlayer = new Player(playerName, 0, currentSession, false);
        session.setAttribute("currentPlayer", currentPlayer);

        Quest currentQuest = new Quest(JavaServlet.QUEST_NAME, WON_MESSAGE_PATH);
        QuestService questService = new QuestService(currentPlayer, currentQuest, QUESTIONS_JSON_PATH);
        session.setAttribute("questService", questService);

        return questService;
    }
}