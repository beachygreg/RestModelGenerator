package org.remotetech.parsing.files;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * User: greg
 * Date: 23/04/13
 * Time: 8:16 PM
 */
public class FileUtil {

    public static File getACompanyFile(File dir) throws IOException {

        return new FileUtil().getCompanyFile(dir);
    }

    public File getCompanyFile(File dir) throws IOException {
        final InputStream resourceAsStream = this.getClass().getClassLoader()
                .getResourceAsStream("company.model");
        final File company = new File(dir,"company.model");
        FileUtils.copyInputStreamToFile(resourceAsStream, company);
        company.deleteOnExit();
        return company;
    }
    public static File getAUserFile(File dir) throws IOException {

        return new FileUtil().getUserFile(dir);
    }

    public File getUserFile(File dir) throws IOException {
        final InputStream resourceAsStream = this.getClass().getClassLoader()
                .getResourceAsStream("user.model");
        final File user = new File(dir,"user.model");
        FileUtils.copyInputStreamToFile(resourceAsStream, user);
        user.deleteOnExit();
        return user;
    }
}
