package org.remotetech.parsing.files;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 10:01 AM
 */
public class ModelFileFilter implements FilenameFilter {

    public static final String MODEL_SUFFIX = ".model";

    @Override
    public boolean accept(File dir, String name) {
        if(StringUtils.endsWith(name, MODEL_SUFFIX)){
            return true;
        }
        return false;
    }
}
