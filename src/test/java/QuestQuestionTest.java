import es.javarush.kapyrin.quest.entity.Question;
import es.javarush.kapyrin.quest.repository.JsonQuestRepository;
import es.javarush.kapyrin.quest.repository.QuestQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestQuestionTest {
    private QuestQuestion questQuestion;

    @BeforeEach
    public void setUp() {
        String testFilePath = "questionsTestJson.json";

        questQuestion = new QuestQuestion(testFilePath);
    }


    @Test
    public void testQuestQuestionReturnCorrectListSize() {
        int size = questQuestion.QuestionsSize();
        assertNotNull(size);
        assertEquals(5, size);
    }

    @Test
    public void testQuestQuestionReturnValidQuestionByIndex() {
        Question testQuestion = questQuestion.returnQuestionByIndex(2);
        assertNotNull(testQuestion);
        Question validQuestion = new Question(
                "Правильно. Поздравляю, ты Джун. А что представляет собой объект в Java?",
                "Экземпляр класса",
                "Примитив"
        );

        assertEquals(validQuestion, testQuestion);
    }

    @Test
    public void testQuestQuestionReturnIndexOfBoundExceptionWhenIndexIsInvalid() {
        int questionsSize = questQuestion.QuestionsSize();
        int invalidIndex = questionsSize + 5;
        try {
            Question question = questQuestion.returnQuestionByIndex(invalidIndex);
            fail("There is a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
}



