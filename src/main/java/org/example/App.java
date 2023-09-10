package org.example;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

import org.example.model.Replacement;
import org.example.replace.Replace;
import org.example.restore.Restore;
import org.example.utils.input.GetDataFromApi;
import org.example.utils.input.Read;
import org.example.utils.output.Write;
import org.json.JSONArray;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        Read read = new Read();
        Write write = new Write();
        GetDataFromApi get = new GetDataFromApi(HttpClient.newHttpClient());
        Replace replace = new Replace();
        Restore restore = new Restore();

        JSONArray replacementsJson = read.readJsonArrayFromFile("info/replacement.json");
        JSONArray dataFromApi = get.getDataFromApi();

        List<Replacement> replacements = replace.convertToReplacements(replacementsJson);
        List<String> fixedMessages = restore.fixMessages(replacements, dataFromApi);

        write.writeJsonArrayToFile("info/result.json", new JSONArray(fixedMessages));

    }
}

