package org.example.restore;

public interface RestoreMapper<T1, T2, R> {
    R convertToMessages(T1 replacements, T2 data);
}
