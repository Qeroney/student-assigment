package org.example.data;

import org.example.utils.api.DataProvider;
import org.example.utils.api.UrlDataProvider;
import org.example.utils.file.JsonFileHandler;
import org.example.utils.file.JsonOperation;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RunWith(MockitoJUnitRunner.class)
public class UrlDataProviderTest {

    @Mock
    private HttpClient client;

    @InjectMocks
    private UrlDataProvider dataProvider;

    private final JsonOperation operation = new JsonFileHandler();
    private final JSONParser parser = new JSONParser();
    private final String API = "https://raw.githubusercontent.com/thewhitesoft/student-2023-assignment/main/data.json";

    @Test
    public void dataFromApi() throws ParseException, IOException, InterruptedException {
        //Arrange
        HttpResponse<String> response = Mockito.mock(HttpResponse.class);
        Object file = operation.readJsonArrayFromFile("src/test/resources/data.json");

        HttpRequest request = HttpRequest.newBuilder()
                                         .GET()
                                         .uri(URI.create(API))
                                         .build();

        Mockito.when(response.body()).thenReturn(file.toString());
        Mockito.when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        //Act
        Object actual = dataProvider.getDataFromApi();

        //Assert
        Object expected = parser.parse(file.toString());
        Assert.assertEquals(expected.toString(), actual.toString());
    }
}
