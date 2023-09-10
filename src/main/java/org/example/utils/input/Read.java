package org.example.utils.input;

import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Read {

    public JSONArray readJsonArrayFromFile(String fileName) {

        try {

            String jsonFile = new String(Files.readAllBytes(Paths.get(fileName)));
            return new JSONArray(jsonFile);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
