package org.example.factory;

import org.example.replace.ReplaceConverter;
import org.example.replace.Replacer;
import org.example.restore.Restore;
import org.example.restore.RestoreMessages;
import org.example.utils.api.GetDataFromApi;
import org.example.utils.api.GetterData;
import org.example.utils.file.*;

import java.net.http.HttpClient;

public class JsonReplacementFactory implements ReplacementFactory {
    @Override
    public Replacer createReplaceConverter() {
        return new ReplaceConverter();
    }

    @Override
    public GetterData createGetterData() {
        return new GetDataFromApi(HttpClient.newHttpClient());
    }

    @Override
    public Restore createRestoreMessages() {
        return new RestoreMessages();
    }

    @Override
    public JsonOperation createFileOperation() {
        return new JsonFileHandler();
    }
}
