package es.javarush.kapyrin.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Question {

        private String theQuestion;
        private String correctAnswer;
        private String wrongAnswer;


}
