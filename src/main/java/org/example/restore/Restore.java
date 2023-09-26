package org.example.restore;

import org.example.model.Replacement;
import org.json.JSONArray;

import java.util.List;

public interface Restore {

    List<String> fixMessages(List<Replacement> replacements, JSONArray data);
}
