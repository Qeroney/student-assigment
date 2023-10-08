package org.example.restore;

import org.example.replace.ReplaceConverter;
import org.example.replace.ReplaceMapper;
import org.example.utils.file.JsonFileHandler;
import org.example.utils.file.JsonOperation;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StartReplaceTest {

    @Test
    public void mainLogicTest() {
        //Arrange
        ReplaceMapper replaceMappers = new ReplaceConverter();
        RestoreMapper restoreMapper = new RestoreConverter();
        JsonOperation operation = new JsonFileHandler();
        Object file = operation.readJsonArrayFromFile("info/replacement.json");
        List<String> data = List.of(
                "Two roads diverged in a yellow d12324344rgg6f5g6gdf2ddjf,",
                "Robert Frost poetAnd sorry I cou1d not trave1 both",
                "An other text",
                "And be one trave1er, long I stood",
                "And 1ooked down one as far as I cou1d",
                "Bla-bla-bla-blaaa, just some RANDOM tExT",
                "To where it bent in the undergrowth;",
                "Then Random text, yeeep the other, as just as fair,",
                "And having perhaps parentheses - that is a smart word,",
                "Bla-bla-bla-blaaa, just some RANDOM tExT",
                "Because it was grassy and wanted wear;",
                "An other text",
                "An other text",
                "Though as for that the passing there",
                "Emptry... or NOT! them rea11y about the same,",
                "And both that morning equally lay",
                "In 1eaves no step had trodden b1ack.",
                "Oh, I kept the first for another day!",
                "Yet Skooby-dooby-doooo 1eads on to way,",
                "Ha-haaa, hacked you.",
                "An other text",
                "I shall be te11ing this with a sigh",
                "sdshdjdskfm sfjsdif jfjfidjf",
                "Two roads diverged in a d12324344rgg6f5g6gdf2ddjf, and I",
                "I Random text, yeeep the one less traveled by,",
                "And that has made a11 the difference.",
                "Bla-bla-bla-blaaa, just some RANDOM tExT");

        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(data);

        //Act
        Object replacements = replaceMappers.convertToReplacements(file);
        Object actual = restoreMapper.convertToMessages(replacements, jsonArray);

        //Assert
        List<String> expected = Arrays.asList("Two roads diverged in a yellow wood,",
                                              "Robert Frost poetAnd sorry I could not travel both",
                                              "And be one traveler, long I stood",
                                              "And looked down one as far as I could",
                                              "To where it bent in the undergrowth;",
                                              "Then took the other, as just as fair,",
                                              "And having perhaps the better claim,",
                                              "Because it was grassy and wanted wear;",
                                              "Though as for that the passing there",
                                              "Had worn them really about the same,",
                                              "And both that morning equally lay",
                                              "In leaves no step had trodden black.",
                                              "Oh, I kept the first for another day!",
                                              "Yet knowing how way leads on to way,",
                                              "I doubted if I should ever come back.",
                                              "I shall be telling this with a sigh",
                                              "Somewhere ages and ages hence:",
                                              "Two roads diverged in a wood, and I",
                                              "I took the one less traveled by,",
                                              "And that has made all the difference."
                                             );

        Assert.assertEquals(expected, actual);
    }
}
