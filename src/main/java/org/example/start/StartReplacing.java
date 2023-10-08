package org.example.start;

import org.example.factory.ReplacementFactory;
import org.example.model.Replacement;
import org.example.replace.ReplaceMapper;
import org.example.restore.RestoreMapper;
import org.example.utils.api.DataProvider;
import org.example.utils.file.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class StartReplacing {

    private final ReplaceMapper<List<JSONObject>, List<Replacement>> replace;
    private final DataProvider<JSONArray> getData;
    private final RestoreMapper<List<Replacement>, JSONArray, List<String>> restore;
    private final JsonOperation<String, List<String>, JSONArray> operation;
    private final JSONArray json = new JSONArray();

    public StartReplacing(ReplacementFactory factory) {
        this.replace = factory.getReplaceConverterInstance();
        this.getData = factory.getDataProviderInstance();
        this.restore = factory.getRestoreConverterInstance();
        this.operation = factory.getJsonFileHandlerInstance();
    }

    public void replacing(String fileName, String filePath) throws IOException, InterruptedException, ParseException {

        JSONArray file = operation.readJsonArrayFromFile(fileName);
        List<Replacement> replacements = replace.convertToReplacements(file);
        JSONArray api = getData.getDataFromApi();
        List<String> messages = restore.convertToMessages(replacements, api);
        json.addAll(messages);
        operation.writeJsonArrayToFile(json, filePath);
    }
}
