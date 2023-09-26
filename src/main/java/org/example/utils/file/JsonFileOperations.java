package org.example.utils.file;

import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileOperations implements FileOperations {

    @Override
    public JSONArray readJsonArrayFromFile(String fileName) {

        try {

            String jsonFile = new String(Files.readAllBytes(Paths.get(fileName)));
            return new JSONArray(jsonFile);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void writeJsonArrayToFile(String filePath, JSONArray jsonArray) {

        try (FileWriter fileWriter = new FileWriter(filePath)) {

            fileWriter.write(jsonArray.toString());

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
