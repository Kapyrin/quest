import es.javarush.kapyrin.quest.entity.Player;
import es.javarush.kapyrin.quest.entity.Quest;
import es.javarush.kapyrin.quest.entity.Question;
import es.javarush.kapyrin.quest.repository.QuestQuestion;
import es.javarush.kapyrin.quest.service.QuestService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestServiceTest {
    private QuestService questService;
   private static final String WON_MESSAGE_PATH = "won.txt";
    @BeforeEach
    public void setUp() {
        Player player = new Player("TestPlayer", 0, "testSession", false);
        Quest quest = new Quest("TestQuest",WON_MESSAGE_PATH);
        String questionsPath = "questionsTestJson.json";

        QuestQuestion questQuestion = mock(QuestQuestion.class);
        questService = new QuestService(player, quest, questionsPath);
    }

    @Test
    public void testCheckAnswerCorrectAnswer() {
        String selectedAnswer = "Java";
        boolean isAnswerCorrect = questService.checkAnswer(selectedAnswer);
        assertTrue(isAnswerCorrect);
    }

    @Test
    public void testCheckAnswerWrongAnswer() {
        String selectedAnswer = "HTML";
        boolean isAnswerCorrect = questService.checkAnswer(selectedAnswer);
        assertFalse(isAnswerCorrect);
    }

    @Test
    public void testQuestServiceReturnCurrenQuestion() {
        Question currentQuestion = questService.getCurrentQuestion();
        String testString = "Узнаем получится из тебя программист или нет? Начнем с самого легкого. Что из этого является языком программирования?";
        assertEquals(testString, currentQuestion.getTheQuestion());
    }


}