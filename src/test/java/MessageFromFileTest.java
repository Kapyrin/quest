import es.javarush.kapyrin.quest.repository.JsonQuestRepository;
import es.javarush.kapyrin.quest.repository.MessageFromFile;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;


public class MessageFromFileTest {

    private MessageFromFile messageFromFile;


    @BeforeEach
    public void setUp() {
        String testFilePath = "testText.txt";

        messageFromFile = new MessageFromFile(testFilePath);
    }
    @Test
    public void testGetMessage() {
        String testMessage = messageFromFile.getMessage();
        assertNotNull(testMessage);
        assertFalse(testMessage.isEmpty());
        assertEquals("This is test text.", testMessage);
    }



}

