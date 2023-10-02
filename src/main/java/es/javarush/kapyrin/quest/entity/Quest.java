package es.javarush.kapyrin.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor


public class Quest {
    private String questName;
//    private List<Question> questions;
    private String wonMessage;

}


