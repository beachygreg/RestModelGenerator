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
public class FileLocationService {


    public static final String SRC = "./src/";
    private String src;

    public FileLocationService(String languageDir){
       src = SRC + languageDir;
    }

    public void createFolder(String location){
        final File file = new File(src + location);

        if(!file.exists()){
            file.mkdirs();
        }
    }

    public void createFile(String location, String content, String name) {
        final File file = new File(src +location, name);
        try {
            FileUtils.writeStringToFile(file, content);
        } catch (IOException e) {
            throw new GenerationException("Could not write file to the given directory [" + location + name + "]" );
        }
    }

    public void createFile(String content, String name){
        createFile("", content, name);
    }

}