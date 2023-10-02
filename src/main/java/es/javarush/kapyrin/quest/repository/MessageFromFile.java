package es.javarush.kapyrin.quest.repository;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Data

public class MessageFromFile implements QuestMessage {
    private String filePath;

    public MessageFromFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMessage() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);

            if (inputStream != null) {
                String fromFile = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                return fromFile;
            } else {
                throw new FileNotFoundException("Resource not found: " + filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
