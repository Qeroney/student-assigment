package org.example.utils.file;

public interface JsonOperation<T1, T2, R> {
    R readJsonArrayFromFile(T1 fileName);

    void writeJsonArrayToFile(T2 json, T1 filePath);

}
