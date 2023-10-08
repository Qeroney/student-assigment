package org.example.replace;

public interface ReplaceMapper<T, R> {
    R convertToReplacements(T data);
}
