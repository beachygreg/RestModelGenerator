package org.remotetech.parsing.parsing;

import java.io.File;

/**
 * User: greg
 * Date: 21/04/13
 * Time: 12:15 PM
 */
public class UnreadableModelFileException extends RuntimeException {

    public UnreadableModelFileException(File file){
        super("Could not read the given Model file = " + file.getPath() );
    }
}
