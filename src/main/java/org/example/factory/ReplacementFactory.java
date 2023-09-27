package org.example.factory;

import org.example.replace.Replacer;
import org.example.restore.Restore;
import org.example.utils.api.GetterData;
import org.example.utils.file.JsonOperation;

public interface ReplacementFactory {
    Replacer createReplaceConverter();

    GetterData createGetterData();

    Restore createRestoreMessages();

    JsonOperation createFileOperation();
}
