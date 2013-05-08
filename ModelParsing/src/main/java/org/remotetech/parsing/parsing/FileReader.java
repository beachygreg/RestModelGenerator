package org.remotetech.parsing.parsing;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * User: greg
 * Date: 21/04/13
 * Time: 1:26 PM
 */
@Service
public class FileReader {

    public String getStrippedFileString(File file) {
        final String fileString;
        try {
            fileString = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            throw new UnreadableModelFileException(file);
        }
        if(StringUtils.isEmpty(fileString)){
            throw new InvalidModelFileFormatException(file, "File us empty or can not be read.");
        }
        final String strippedWhitespace = StringUtils.deleteWhitespace(fileString);
        final String cleanString = StringUtils.remove(strippedWhitespace, System.getProperty("line.separator"));
        return cleanString;
    }



}