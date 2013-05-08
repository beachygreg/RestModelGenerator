package org.remotetech.parsing.files;


import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 9:47 AM
 */
@Service
public class ModelFileService {

    public List<File> getModelFiles(String path){
        final File file = new File(path);
        final File[] files = file.listFiles(new ModelFileFilter());

        final ArrayList<File> files1 = new ArrayList<File>();
        if(files == null) return files1;
        for (File file1 : files) {
            files1.add(file1);
        }

        return files1;
    }
}
