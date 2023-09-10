package org.example.utils.output;

import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;

public class Write {

    public void writeJsonArrayToFile(String filePath, JSONArray jsonArray) {

        try (FileWriter fileWriter = new FileWriter(filePath)) {

            fileWriter.write(jsonArray.toString());

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
