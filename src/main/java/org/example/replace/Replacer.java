package org.example.replace;

import org.example.model.Replacement;
import org.json.JSONArray;

import java.util.List;

public interface Replacer {

    List<Replacement> convertToReplacements(JSONArray json);

}
