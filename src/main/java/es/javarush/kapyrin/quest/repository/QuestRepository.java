package es.javarush.kapyrin.quest.repository;

import es.javarush.kapyrin.quest.entity.Player;
import es.javarush.kapyrin.quest.entity.Question;

import java.util.List;

public interface QuestRepository {
    List<Question> getQuestions();
}
