package org.example.model;

public class Replacement {
    private String replacement;

    private String source;

    public Replacement(String replacement, String source) {
        this.replacement = replacement;
        this.source = source;
    }
    public String getReplacement() {
        return replacement;
    }
    public String getSource() {
        return source;
    }
}
