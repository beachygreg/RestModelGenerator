package org.remotetech.codeGeneration.ruby;

import org.remotetech.codeGeneration.CodeGenerator;
import org.remotetech.codeGeneration.FileLocationService;
import org.remotetech.types.ModelObject;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.List;

/**
 * User: greg
 * Date: 12/05/13
 * Time: 11:03 AM
 */
public class RubyGenerator implements CodeGenerator {
    private FileLocationService fileLocationService = new FileLocationService("ruby/");


    public void generateCode(List<ModelObject> modelObjects) {
        final STGroup stGroup = new STGroupFile("templates/rubyClass.stg");

        for (ModelObject modelObject : modelObjects) {
            fileLocationService.createFolder("");
            final ST clazz = stGroup.getInstanceOf("class");

            clazz.add("modelObject", modelObject);

            fileLocationService.createFile(clazz.render(), modelObject.getClassName());
        }

    }
}
