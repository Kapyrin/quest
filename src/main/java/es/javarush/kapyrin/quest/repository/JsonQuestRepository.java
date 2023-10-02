package es.javarush.kapyrin.quest.repository;

import es.javarush.kapyrin.quest.entity.Player;
import es.javarush.kapyrin.quest.entity.Question;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;

import org.json.simple.parser.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonQuestRepository implements QuestRepository {

    String jsonPathFile;

    public JsonQuestRepository(String jsonPathFile) {
        this.jsonPathFile = jsonPathFile;
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(jsonPathFile);

            if (inputStream == null) {
                throw new FileNotFoundException("JSON resource not found: " + jsonPathFile);
            }

            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            Object obj = parser.parse(reader);
            JSONArray questionArray = (JSONArray) obj;

            for (Object question : questionArray) {
                JSONObject questionFromJson = (JSONObject) question;
                String theQuestion = (String) questionFromJson.get("question");
                String correctAnswer = (String) questionFromJson.get("correctAnswer");
                String wrongAnswer = (String) questionFromJson.get("wrongAnswer");
                questions.add(new Question(theQuestion, correctAnswer, wrongAnswer));
            }

            return questions;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("JSON resource not found: " + jsonPathFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON resource: " + jsonPathFile, e);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing JSON resource: " + jsonPathFile, e);
        }
    }
}
