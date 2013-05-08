package org.remotetech.parsing.parsing;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.remotetech.types.ModelInteger;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 11:02 AM
 */
@RunWith(MockitoJUnitRunner.class)
public class FileParsingTest {


    @InjectMocks
    private FileParsing fileParsing;

    @Mock
    private FileReader mockedFileReader;
    @Mock
    private File file;
    @Mock
    private VariableValidator mockVariableValidator;

    @Mock
    private LineParser mockLineParser;
    @Spy
    private FileParsing fileParsingSpy;

    @Test
    public void testGetClassName() throws Exception {
        String testOne = "user.model";

        final String className = fileParsing.getClassName(testOne);

        assertThat(className, is("User"));
    }

    @Test
    public void testGetClassName2() throws Exception {
        String testOne = "User.model";

        final String className = fileParsing.getClassName(testOne);

        assertThat(className, is("User"));
    }

    @Test
    public void testGetClassName3() throws Exception {
        String testOne = "userCase.model";

        final String className = fileParsing.getClassName(testOne);

        assertThat(className, is("UserCase"));
    }

    @Test
    public void testGetBody() {

        when(mockedFileReader.getStrippedFileString(file)).thenReturn("test/file;{var1:String;}");
        final String body = fileParsing.getBody(file);
        assertThat(body, is("var1:String;"));

    }

    @Test
    public void testGetBody2() {

        when(mockedFileReader.getStrippedFileString(file)).thenReturn("test/file;{var1:String;list:List:Object;}");
        final String body = fileParsing.getBody(file);
        assertThat(body, is("var1:String;list:List:Object;"));

    }

    @Test
    public void testGetBodyLines() {

        doReturn("var1:String;list:List:Object;").when(fileParsingSpy).getBody(file);

        final List<String> bodyLines = fileParsingSpy.getBodyLines(file);

        assertThat(bodyLines, hasItem("var1:String"));
        assertThat(bodyLines, hasItem("list:List:Object"));
    }


}
