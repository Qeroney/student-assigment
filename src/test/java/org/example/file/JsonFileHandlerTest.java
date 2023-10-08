package org.example.file;

import org.example.utils.file.JsonFileHandler;
import org.example.utils.file.JsonOperation;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonFileHandlerTest {

    private final JsonOperation operation = new JsonFileHandler();

    @Rule
    private final TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void readFromFile() throws IOException {
        //Arrange
        String file = "src/test/resources/test.json";
        String expected = new String(Files.readAllBytes(Paths.get(file)));

        //Act
        Object actual = operation.readJsonArrayFromFile("info/replacement.json");

        //Assert
        assertEquals(expected, actual.toString());
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

