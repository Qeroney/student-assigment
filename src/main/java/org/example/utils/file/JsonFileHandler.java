package org.example.utils.file;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;

public class JsonFileHandler implements JsonOperation<String, List<String>, JSONArray> {
    @Override
    public JSONArray readJsonArrayFromFile(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            JSONParser parser = new JSONParser();
            return (JSONArray) parser.parse(reader);

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeJsonArrayToFile(List<String> json, String filePath) {

        try (FileWriter fileWriter = new FileWriter(filePath)) {

            fileWriter.write(json.toString());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
