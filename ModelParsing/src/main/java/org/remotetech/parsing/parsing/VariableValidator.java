package org.remotetech.parsing.parsing;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * User: greg
 * Date: 23/04/13
 * Time: 8:39 PM
 */
@Service
public class VariableValidator {

    public void validateLine(File file, String bodyLine) {
        String[] variablesLine = StringUtils.split(bodyLine, FileParsing.CHARS_SEPARATOR);
        if(ArrayUtils.getLength(variablesLine) != 2 && ArrayUtils.getLength(variablesLine) != 3){
            throw new InvalidModelFileFormatException(file, "Could not separate variable and type by ':' string = '" + bodyLine +"'");
        }
    }
}
