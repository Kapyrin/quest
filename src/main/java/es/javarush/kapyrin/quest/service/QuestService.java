package es.javarush.kapyrin.quest.service;

import es.javarush.kapyrin.quest.entity.Player;
import es.javarush.kapyrin.quest.entity.Quest;
import es.javarush.kapyrin.quest.entity.Question;
import es.javarush.kapyrin.quest.repository.MessageFromFile;
import es.javarush.kapyrin.quest.repository.QuestQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static es.javarush.kapyrin.quest.controller.JavaServlet.WON_MESSAGE_PATH;

@Data
@AllArgsConstructor
public class QuestService {
    private Player currentPlayer;
    private Quest currentQuest;
    private QuestQuestion questQuestion;
    private int currentQuestionNumber;

    public QuestService(Player currentPlayer, Quest currentQuest, String questionsPath) {
        this.currentPlayer = currentPlayer;
        this.currentQuest = currentQuest;
        currentQuestionNumber = 0;
        questQuestion = new QuestQuestion(questionsPath);
    }

    public boolean checkAnswer(String selectedAnswer) {
        if (selectedAnswer != null && selectedAnswer.equals(getCurrentQuestion().getCorrectAnswer())) {
            if (selectedAnswer.equals(getCurrentQuestion().getCorrectAnswer())) {
                currentQuestionNumber++;
                return true;
            }

        }
        return false;
    }

    public boolean isQuestComplete() {
        return currentQuestionNumber >= questQuestion.QuestionsSize();
    }
    public String getVictoryMessage() {
        if (isQuestComplete()) {
            return new MessageFromFile(WON_MESSAGE_PATH).getMessage();
        } else {
            return null;
        }
    }
    public Question getCurrentQuestion() {
        return questQuestion.returnQuestionByIndex(currentQuestionNumber);
    }
    public List<String> shuffleAnswers (Question question) {
        List<String> answers = new ArrayList<>();
        answers.add(question.getCorrectAnswer());
        answers.add(question.getWrongAnswer());
        Collections.shuffle(answers);
        return answers;
    }
    public Question getQuestion() {
        return getCurrentQuestion();
    }
}