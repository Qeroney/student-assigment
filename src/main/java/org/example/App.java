package org.example;

import org.example.factory.JsonReplacementFactory;
import org.example.factory.ReplacementFactory;
import org.example.start.StartReplacing;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        ReplacementFactory factory = new JsonReplacementFactory();
        StartReplacing startReplacing = new StartReplacing(factory);
        startReplacing.replacing();
    }
}

