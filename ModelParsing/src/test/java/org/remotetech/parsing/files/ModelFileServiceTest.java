package org.remotetech.parsing.files;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 10:10 AM
 */
public class ModelFileServiceTest {
    private ModelFileService modelFileService = new ModelFileService();

    @Test
    public void testGetModelFiles() throws Exception {
        final File tempFile = File.createTempFile("goodFileName", ".model");
        final File tempFile2 = File.createTempFile("BadFileName", ".models");
        final File tempFile3 = File.createTempFile("BadFileName", ".Model");

        final List<File> modelFiles = modelFileService.getModelFiles(tempFile.getParentFile().getPath());

        assertThat(modelFiles, hasItem(tempFile));
        assertThat(modelFiles,not( hasItem(tempFile2)));
        assertThat(modelFiles,not(hasItem(tempFile3)));

        tempFile.delete();
        tempFile3.delete();
        tempFile2.delete();
    }


}
