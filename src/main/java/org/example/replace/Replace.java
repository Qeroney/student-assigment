package org.example.replace;

import org.example.model.Replacement;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Replace {

    public List<Replacement> convertToReplacements(JSONArray json) {

        List<Replacement> list = new ArrayList<>();

        for (Object o : json) {

            JSONObject replacementJson = (JSONObject) o;
            Object replacementObj = replacementJson.get("replacement");
            Object sourceObj = replacementJson.get("source");
            String source = null;

            if (sourceObj != null) {
                source = sourceObj.toString();
            }

            String replacement = replacementObj.toString();
            list.add(0, new Replacement(replacement, source));

        }
        return list;
    }
}
