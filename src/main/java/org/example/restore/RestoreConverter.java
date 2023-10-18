package org.example.restore;

import org.example.model.Replacement;
import org.json.simple.JSONArray;

import java.util.List;

public class RestoreConverter implements RestoreMapper<List<Replacement>, JSONArray, JSONArray> {
    @Override
    public JSONArray convertToMessages(List<Replacement> replacements, JSONArray data) {
        JSONArray array = new JSONArray();

        data.stream()
            .map(Object::toString)
            .forEach(originalMessage -> {
                String newMessage = replacements.stream()
                                                .reduce(originalMessage, (message, replacement) -> {
                                                    String replacementStr = replacement.getReplacement();
                                                    String sourceStr = replacement.getSource();

                                                    if (sourceStr == null) {
                                                        return message.toString().replace(replacementStr, "");
                                                    } else {
                                                        return message.toString().replace(replacementStr, sourceStr);
                                                    }
                                                }, (message, replacement) -> replacement).toString();
                if (!newMessage.isEmpty()) {
                    array.add(newMessage);
                }
            });
        return array;
    }
}







