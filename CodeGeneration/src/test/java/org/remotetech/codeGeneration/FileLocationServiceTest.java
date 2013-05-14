package org.remotetech.codeGeneration;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * User: greg
 * Date: 28/04/13
 * Time: 4:59 PM
 */
public class FileLocationServiceTest {
    public static final String TEST_DIR = "test/unit";
    public static final String SRC = "./src/";
    private FileLocationService fileLocationService = new FileLocationService("");


    @Test
    public void testCreatePackageAndFile() throws Exception {
        fileLocationService.createFolder(TEST_DIR);

        final File dir = new File(SRC + TEST_DIR);
        assertThat(dir.exists(), is(true));

        new File(SRC + "test").deleteOnExit();

        fileLocationService.createFile(TEST_DIR, "test content", "test.java");

        final File file = new File(SRC + TEST_DIR, "test.java");
        assertThat(file.exists(), is(true));
        assertThat(FileUtils.readFileToString(file, "UTF-8"), is("test content"));

        file.delete();
        dir.delete();

    }
}
