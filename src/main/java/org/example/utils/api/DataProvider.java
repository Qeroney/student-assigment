package org.example.utils.api;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface DataProvider<R> {

    R getDataFromApi() throws IOException, InterruptedException, ParseException;
}
