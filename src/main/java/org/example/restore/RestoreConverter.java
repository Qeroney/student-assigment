package org.example.restore;

import org.example.model.Replacement;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class RestoreConverter implements RestoreMapper<List<Replacement>, JSONArray, List<String>> {
    @Override
    public List<String> convertToMessages(List<Replacement> replacements, JSONArray data) {
        List<String> list = new ArrayList<>();

        for (int j = 0; j < data.size(); j++) {
            String message = data.get(j).toString();

            for (Replacement replacement : replacements) {
                String replacementStr = replacement.getReplacement();
                String sourceStr = replacement.getSource();

                if (sourceStr == null) {
                    message = message.replaceAll(replacementStr, "");
                } else {
                    message = message.replaceAll(replacementStr, sourceStr);
                }
            }
            if (!message.isEmpty()) {
                list.add(message);
            }
        }
        return list;
    }
}







