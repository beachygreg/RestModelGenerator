package org.remotetech.codeGeneration;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * User: greg
 * Date: 28/04/13
 * Time: 4:27 PM
 */
@Service
public class FileLocationService {

    public static final String SRC = "./src/";

    public void createPackage(String location){
        final File file = new File(SRC + location);
        if(!file.exists()){
            file.mkdirs();
        }
    }

    public void createFile(String location, String content, String name){
        final File file = new File(SRC +location, name);
        try {
            FileUtils.writeStringToFile(file, content);
        } catch (IOException e) {
            throw new GenerationException("Could not write file to the given directory [" + location + name + "]" );
        }
    }

}