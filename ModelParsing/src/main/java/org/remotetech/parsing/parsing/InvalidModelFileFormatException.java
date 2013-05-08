package org.remotetech.parsing.parsing;

import java.io.File;

/**
 * User: greg
 * Date: 21/04/13
 * Time: 12:19 PM
 */
public class InvalidModelFileFormatException extends RuntimeException {

    public InvalidModelFileFormatException(File file, String message){
        super("Error[" +message + "] in file " + file.getPath());
    }
}
