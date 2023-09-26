package org.example.utils.file;

import org.json.JSONArray;

public interface FileOperations {

    JSONArray readJsonArrayFromFile(String fileName);
    void writeJsonArrayToFile(String filePath, JSONArray jsonArray);
}
