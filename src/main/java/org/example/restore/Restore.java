package org.example.restore;

import org.example.model.Replacement;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Restore {

    public List<String> fixMessages(List<Replacement> replacements, JSONArray data) {

        List<String> list = new ArrayList<>();

        for (int j = 0; j < data.length(); j++) {
            String message = data.getString(j);

            for (Replacement replacement : replacements) {
                Object sourceObj = replacement.getSource();
                Object replacementObj = replacement.getReplacement();
                String replacementStr = replacementObj.toString();
                String sourceStr = sourceObj.toString();

                if (sourceObj.equals("null")) {

                    message = message.replace(replacementStr, "");

                } else {
                    message = message.replace(replacementStr, sourceStr);
                }
            }
            if (!message.isEmpty()) {
                list.add(message);
            }
        }
        return list;
    }
}
