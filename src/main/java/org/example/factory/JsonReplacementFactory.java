package org.example.factory;

import org.example.replace.ReplaceConverter;
import org.example.replace.ReplaceMapper;
import org.example.restore.RestoreMapper;
import org.example.restore.RestoreConverter;
import org.example.utils.api.UrlDataProvider;
import org.example.utils.api.DataProvider;
import org.example.utils.file.*;

import java.net.http.HttpClient;

public class JsonReplacementFactory implements ReplacementFactory {
    @Override
    public ReplaceMapper getReplaceConverterInstance() {
        return new ReplaceConverter();
    }

    @Override
    public DataProvider getDataProviderInstance() {
        return new UrlDataProvider(HttpClient.newHttpClient());
    }

    @Override
    public RestoreMapper getRestoreConverterInstance() {
        return new RestoreConverter();
    }

    @Override
    public JsonOperation getJsonFileHandlerInstance() {
        return new JsonFileHandler();
    }
}
