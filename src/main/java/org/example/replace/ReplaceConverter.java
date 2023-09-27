package org.example.replace;

import org.example.model.Replacement;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReplaceConverter implements Replacer  {
    @Override
    public List<Replacement> convertToReplacements(JSONArray json) {
        List<Replacement> list = new ArrayList<>();

        for (Object o : json) {
            JSONObject replacementJson = (JSONObject) o;
            Object replacementObj = replacementJson.get("replacement");
            Object sourceObj = replacementJson.get("source");

            String replacement = replacementObj.toString();
            String source;
            if (sourceObj != null) {
                source = sourceObj.toString();
            } else {
                source = null;
            }
            list.add(0, new Replacement(replacement, source));
        }
        return list;
    }
}
