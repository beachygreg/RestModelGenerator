package org.remotetech.parsing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.List;

import static org.remotetech.parsing.files.FileUtil.getACompanyFile;
import static org.remotetech.parsing.files.FileUtil.getAUserFile;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * User: greg
 * Date: 27/04/13
 * Time: 9:19 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:model-parsing-context.xml")
public class ModelObjectServiceTest {

    @Autowired
    private ModelObjectService modelObjectService;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();



    @Test
    public void testGenerateObjectsFromDirectory() throws Exception {
        final File companyFile = getACompanyFile(folder.getRoot());
        final File userFile = getAUserFile(folder.getRoot());

        final List<ModelObject> modelVariableTypes = modelObjectService.generateObjectsFromDirectory(userFile.getParent());

        assertThat(modelVariableTypes.size(), is(2));

    }


}
