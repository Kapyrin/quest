import es.javarush.kapyrin.quest.entity.Player;
import es.javarush.kapyrin.quest.entity.Quest;
import es.javarush.kapyrin.quest.entity.Question;
import es.javarush.kapyrin.quest.repository.JsonQuestRepository;
import es.javarush.kapyrin.quest.repository.MessageFromFile;
import es.javarush.kapyrin.quest.repository.QuestQuestion;
import es.javarush.kapyrin.quest.service.QuestService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonQuestRepositoryTest {

    private JsonQuestRepository jsonQuestRepository;

    @BeforeEach
    public void setUp() {
        String testFilePath = "questionsTestJson.json";

        jsonQuestRepository = new JsonQuestRepository(testFilePath);
    }


    @Test
    public void JsonQuestRepositoryReturnListOfQuestions() {
        List<Question> testList = new ArrayList<>();

        Question question1 = new Question(
                "Узнаем получится из тебя программист или нет? Начнем с самого легкого. Что из этого является языком программирования?",
                "Java",
                "HTML"
        );
        testList.add(question1);


        Question question2 = new Question(
                "Хорошо. К каким языкам программирования относится Java?",
                "Объектно-ориентированным",
                "Процедурным"
        );
        testList.add(question2);


        Question question3 = new Question(
                "Правильно. Поздравляю, ты Джун. А что представляет собой объект в Java?",
                "Экземпляр класса",
                "Примитив"
        );
        testList.add(question3);


        Question question4 = new Question(
                "Замечательно. Ты уже мидл разработчик. Не останавливайся. С чего не может начинаться название класса в Java?",
                "С цифры",
                "С заглавной буквы"
        );
        testList.add(question4);


        Question question5 = new Question(
                "Правильно. И последний вопрос. Во что объединяются классы в Java?",
                "Пакеты",
                "Стаканы"
        );
        testList.add(question5);

        List<Question> questions = jsonQuestRepository.getQuestions();
        assertNotNull(questions);
        assertFalse(questions.isEmpty());
        assertEquals(testList, questions);
    }

    @Test
    public void testQuestionsListSize() {
        List<Question> questions = jsonQuestRepository.getQuestions();
        assertNotNull(questions);
        assertFalse(questions.isEmpty());
        assertEquals(5, questions.size());
    }

}

