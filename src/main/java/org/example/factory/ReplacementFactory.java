package org.example.factory;

import org.example.replace.ReplaceMapper;
import org.example.restore.RestoreMapper;
import org.example.utils.api.DataProvider;
import org.example.utils.file.JsonOperation;

public interface ReplacementFactory {
    ReplaceMapper getReplaceConverterInstance();

    DataProvider getDataProviderInstance();

    RestoreMapper getRestoreConverterInstance();

    JsonOperation getJsonFileHandlerInstance();
}
