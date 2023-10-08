package org.example.utils.api;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UrlDataProvider implements DataProvider<JSONArray> {

    private final HttpClient client;

    private final String API = "https://raw.githubusercontent.com/thewhitesoft/student-2023-assignment/main/data.json";

    public UrlDataProvider(HttpClient httpClient) {
        this.client = httpClient;
    }

    @Override
    public JSONArray getDataFromApi() throws IOException, InterruptedException, ParseException {
        HttpRequest request = HttpRequest.newBuilder()
                                         .GET()
                                         .uri(URI.create(API))
                                         .build();
        HttpResponse<String> data = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(data.body());
    }
}
