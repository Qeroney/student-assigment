package org.example.restore;

import org.example.replace.ReplaceConverter;
import org.example.replace.ReplaceMapper;
import org.example.utils.api.DataProvider;
import org.example.utils.file.JsonFileHandler;
import org.example.utils.file.JsonOperation;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class StartReplaceTest {

    @Test
    public void mainLogicTest() throws IOException, ParseException, InterruptedException {
        //Arrange
        ReplaceMapper replaceMappers = new ReplaceConverter();
        RestoreMapper restoreMapper = new RestoreConverter();
        JsonOperation operation = new JsonFileHandler();
        DataProvider provider = Mockito.mock(DataProvider.class);

        Object replacementJson = operation.readJsonArrayFromFile("src/test/resources/replacement.json");
        Object dataJson = operation.readJsonArrayFromFile("src/test/resources/data.json");
        Object resultJson = operation.readJsonArrayFromFile("src/test/resources/result.json");

        Mockito.when(provider.getDataFromApi()).thenReturn(dataJson);

        //Act
        Object replacements = replaceMappers.convertToReplacements(replacementJson);
        Object actual = restoreMapper.convertToMessages(replacements, dataJson);

        //Assert
        Assert.assertEquals(resultJson, actual);
    }
}
