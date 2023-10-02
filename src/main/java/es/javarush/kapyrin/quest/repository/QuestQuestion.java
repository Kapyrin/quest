package es.javarush.kapyrin.quest.repository;

import es.javarush.kapyrin.quest.entity.Question;

import java.util.List;

public class QuestQuestion {
    private List<Question> questions;
    private Question question;
    private int listQuestionSize;
    private int questionNumber;

    public QuestQuestion(String filePath) {
        questions = new JsonQuestRepository(filePath).getQuestions();
    }

    public int QuestionsSize() {
        int questionsSize = questions.size();
        return questionsSize;

    }

    public Question returnQuestionByIndex(int index) {
        Question currentQuestion = questions.get(index);
        return currentQuestion;
    }

}