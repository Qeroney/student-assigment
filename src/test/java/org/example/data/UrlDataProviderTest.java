package org.example.data;

import org.example.utils.file.JsonFileHandler;
import org.example.utils.file.JsonOperation;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.http.HttpResponse;

public class UrlDataProviderTest {

    @Test
    public void dataFromApi() throws ParseException {
        //Arrange
        HttpResponse<String> response = Mockito.mock(HttpResponse.class);

        JsonOperation operation = new JsonFileHandler();

        Object file = operation.readJsonArrayFromFile("src/test/resources/data.json");

        Mockito.when(response.body()).thenReturn(file.toString());

        //Act
        JSONParser parser = new JSONParser();
        Object expected = parser.parse(response.body());

        //Assert
        Assert.assertEquals(file.toString(), expected.toString());
    }
}
