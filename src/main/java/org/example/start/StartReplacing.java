package org.example.start;

import org.example.factory.ReplacementFactory;
import org.example.model.Replacement;
import org.example.replace.ReplaceConverter;
import org.example.replace.Replacer;
import org.example.restore.Restore;
import org.example.restore.RestoreMessages;
import org.example.utils.api.GetDataFromApi;
import org.example.utils.api.GetterData;
import org.example.utils.file.*;
import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

public class  StartReplacing {

    private final Replacer replace;
    private final GetterData getData;
    private final Restore restore;
    private final JsonOperation operation;

    public StartReplacing(ReplacementFactory factory) {
        this.replace = factory.createReplaceConverter();
        this.getData = factory.createGetterData();
        this.restore = factory.createRestoreMessages();
        this.operation = factory.createFileOperation();
    }

    public void replacing() throws IOException, InterruptedException {

        JSONArray arrayFromFile = operation.readJsonArrayFromFile("info/replacement.json");
        List<Replacement> replacements = replace.convertToReplacements(arrayFromFile);
        JSONArray api = getData.getDataFromApi();
        List<String> fixedMessages = restore.fixMessages(replacements, api);
        operation.writeJsonArrayToFile("info/result.json", new JSONArray(fixedMessages));

    }
}
