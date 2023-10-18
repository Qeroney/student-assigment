package org.example.replace;

import org.example.model.Replacement;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReplaceConverter implements ReplaceMapper<List<JSONObject>, List<Replacement>> {

    @Override
    public List<Replacement> convertToReplacements(List<JSONObject> json) {
        List<Replacement> list = new ArrayList<>();

        json.stream().forEach(repalcementJson -> {
            String replacement = (String) repalcementJson.get("replacement");
            String source = (String) repalcementJson.get("source");

            list.add(0, new Replacement(replacement, source));
        });
        return list;
    }
}

