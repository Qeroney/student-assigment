package org.example.utils.api;

import org.json.JSONArray;

import java.io.IOException;

public interface GetterData {

    JSONArray getDataFromApi() throws IOException, InterruptedException;
}
