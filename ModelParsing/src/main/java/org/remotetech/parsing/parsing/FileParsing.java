package org.remotetech.parsing.parsing;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.remotetech.parsing.files.ModelFileFilter;
import org.remotetech.types.ModelVariableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 10:38 AM
 */
@Service
public class FileParsing {

    public static final String LINE_ENDING = ";";
    public static final String BODY_OPEN = "{";
    public static final String BODY_ENDING = "}";
    public static final String CHARS_SEPARATOR = ":";

    @Autowired
    private FileReader fileReader;


    public String getClassName(File file){
        return getClassName(file.getName());
    }

    public String getClassName(String modelFileName) {
        final String delete = StringUtils.remove(modelFileName, ModelFileFilter.MODEL_SUFFIX);
        final String className = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, delete);
        return className;
    }


    public String getClassDirectory(File file){
        final String strippedFileString = fileReader.getStrippedFileString(file);
        final String[] split = StringUtils.split(strippedFileString, BODY_OPEN);
        if(ArrayUtils.getLength(split)!= 2){
            throw new InvalidModelFileFormatException(file,"There was an issue with the syntax of this file, we could not split the file on '{'");
        }
        final String head = split[0];

        return StringUtils.remove(head, LINE_ENDING);
    }



    public List<String> getBodyLines(File file){
        final String body = getBody(file);
        final String[] split = StringUtils.split(body, LINE_ENDING);
        return Arrays.asList(split);
    }

    public String getBody(File file){
        final String strippedFileString = fileReader.getStrippedFileString(file);
        final String[] split = StringUtils.split(strippedFileString, "{");
        if(ArrayUtils.getLength(split)!= 2){
            throw new InvalidModelFileFormatException(file,"There was an issue with the syntax of this file, we could not split the file on '{'");
        }
        final String body = split[1];
        return StringUtils.remove(body, BODY_ENDING);
    }

}
