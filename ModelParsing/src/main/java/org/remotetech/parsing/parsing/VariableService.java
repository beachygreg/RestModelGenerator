package org.remotetech.parsing.parsing;

import org.apache.commons.lang.StringUtils;
import org.remotetech.types.ModelVariableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: greg
 * Date: 27/04/13
 * Time: 10:31 AM
 */
@Service
public class VariableService {


    @Autowired
    private LineParser lineParser;

    @Autowired
    private VariableValidator variableValidator;

    @Autowired
    private FileParsing fileParsing;

    public List<ModelVariableType> getClassVariables(File file, Map<String, ModelVariableType> standardModelVariables){
        final List<ModelVariableType> modelVariables = new ArrayList<ModelVariableType>();

        final List<String> bodyLines = fileParsing.getBodyLines(file);
        for (String bodyLine : bodyLines) {
            variableValidator.validateLine(file, bodyLine);
            modelVariables.add(lineParser.createVariableForLine(standardModelVariables,  StringUtils.split(bodyLine,FileParsing.CHARS_SEPARATOR)));
        }
        return modelVariables;
    }
}