package org.remotetech.parsing.parsing;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.remotetech.types.ModelInteger;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * User: greg
 * Date: 27/04/13
 * Time: 10:33 AM
 */
@RunWith(MockitoJUnitRunner.class)
public class VariableServiceTest {

    @InjectMocks
    private VariableService variableService;

    @Mock
    private File file;


    @Mock
    private LineParser mockLineParser;

    @Mock
    private FileParsing mockedFileParsing;

    @Mock
    private VariableValidator mockVariableValidator;

    @Test
    public void testGetClassVariables() {
        final HashMap<String, ModelVariableType> stringModelVariableType = new HashMap<String, ModelVariableType>();

        final ArrayList<String> varStrings = new ArrayList<String>();
        final String string1 = "var:String";
        varStrings.add(string1);
        final String string2 = "var:Integer";
        varStrings.add(string2);
        when(mockedFileParsing.getBodyLines(file)).thenReturn(varStrings);


        final ModelVariableType modelInteger = new ModelInteger();
        final ModelVariableType modelObject = new ModelObject();

        when(mockLineParser.createVariableForLine(stringModelVariableType, StringUtils.split(string1, FileParsing.CHARS_SEPARATOR)))
                .thenReturn(modelInteger);
        when(mockLineParser.createVariableForLine(stringModelVariableType, StringUtils.split(string2, FileParsing.CHARS_SEPARATOR)))
                .thenReturn(modelObject);

        final List<ModelVariableType> classVariables = variableService.getClassVariables(file, stringModelVariableType);


        verify(mockVariableValidator).validateLine(file, string1);
        verify(mockVariableValidator).validateLine(file, string2);

        assertThat(classVariables, hasItem(modelInteger));
        assertThat(classVariables, hasItem(modelObject));

    }
}
