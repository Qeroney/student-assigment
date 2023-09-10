package org.example.utils.input;

import org.json.JSONArray;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetDataFromApi {

    private final HttpClient client;

    private final String API = "https://raw.githubusercontent.com/thewhitesoft/student-2023-assignment/main/data.json";

    public GetDataFromApi(HttpClient httpClient) {
        this.client = httpClient;
    }

    public JSONArray getDataFromApi() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                                         .GET()
                                         .uri(URI.create(API))
                                         .build();
        HttpResponse<String> data = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = data.body();
        JSONArray array = new JSONArray(json);
        return array;
    }
}
