package org.example;

import org.example.factory.JsonReplacementFactory;
import org.example.factory.ReplacementFactory;
import org.example.start.StartReplacing;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        ReplacementFactory factory = new JsonReplacementFactory();
        StartReplacing startReplacing = new StartReplacing(factory);
        startReplacing.replacing("info/replacement.json", "info/result.json");
    }
}

