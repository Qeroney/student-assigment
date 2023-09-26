package org.example.start;

import org.example.model.Replacement;
import org.example.replace.ReplaceConverter;
import org.example.replace.Replacer;
import org.example.restore.Restore;
import org.example.restore.RestoreMessages;
import org.example.utils.api.GetDataFromApi;
import org.example.utils.api.GetterData;
import org.example.utils.file.FileOperations;
import org.example.utils.file.JsonFileOperations;
import org.json.JSONArray;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

public class StartReplacing {

    private final Replacer replace;
    private final FileOperations operations;
    private final GetterData getData;
    private final Restore restore;


    public StartReplacing() {
        this.replace = new ReplaceConverter();
        this.getData = new GetDataFromApi(HttpClient.newHttpClient());
        this.restore = new RestoreMessages();
        this.operations = new JsonFileOperations();
    }

    public void replacing() throws IOException, InterruptedException {

        JSONArray arrayFromFile = operations.readJsonArrayFromFile("info/replacement.json");
        List<Replacement> replacements = replace.convertToReplacements(arrayFromFile);
        JSONArray api = getData.getDataFromApi();
        List<String> fixedMessages = restore.fixMessages(replacements, api);
        operations.writeJsonArrayToFile("info/result.json", new JSONArray(fixedMessages));

    }
}
