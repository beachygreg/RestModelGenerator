package org.remotetech.codeGeneration.ruby;

import org.junit.Test;
import org.remotetech.types.ModelObject;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

/**
 * User: greg
 * Date: 13-05-14
 * Time: 3:07 PM
 */
public class RubyModuleServiceTest {

    private RubyFormattingService rubyFormattingService = new RubyFormattingService();
    @Test
    public void testCreateModuleString() throws Exception {
        ModelObject modelObject = new ModelObject();
        modelObject.setClassPath("com/test/package");

        List<String> moduleString = rubyFormattingService.createModuleStrings(modelObject);

        assertThat(moduleString, hasItem("Com"));
        assertThat(moduleString, hasItem("Package"));
        assertThat(moduleString, hasItem("Test"));
    }
}
