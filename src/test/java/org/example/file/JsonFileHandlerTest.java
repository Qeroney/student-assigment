package org.example.file;

import org.example.utils.file.JsonFileHandler;
import org.example.utils.file.JsonOperation;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonFileHandlerTest {

    private final JsonOperation operation = new JsonFileHandler();

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void readFromFile() throws IOException, ParseException {
        //Arrange
        FileReader reader = new FileReader("src/test/resources/replacement.json");
        JSONParser parser = new JSONParser();
        Object parse = parser.parse(reader);

        //Act
        Object actual = operation.readJsonArrayFromFile("src/test/resources/replacement.json");

        //Assert
        assertEquals(parse, actual);
    }

    @Test
    public void testWriteJsonArrayToFile() throws IOException {
        //Arrange
        List<String> json = Arrays.asList("And that has made all the difference", "Random text, yeeep");
        String fileName = "result.json";
        Path filePath = temporaryFolder.getRoot().toPath().resolve(fileName);

        //Act
        operation.writeJsonArrayToFile(json, filePath.toString());

        //Assert
        String saved = new String(Files.readAllBytes(filePath));
        Assert.assertEquals(json.toString(), saved);
    }
}

