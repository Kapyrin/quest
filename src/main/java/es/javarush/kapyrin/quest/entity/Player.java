package es.javarush.kapyrin.quest.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

public class Player {
    private String nickName;
    private int countOfAttempts;
    private String userId;
    private boolean victory;
}
