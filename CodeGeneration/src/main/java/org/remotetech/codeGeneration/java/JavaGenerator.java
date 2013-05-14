package org.remotetech.codeGeneration.java;

import org.remotetech.codeGeneration.CodeGenerator;
import org.remotetech.codeGeneration.FileLocationService;
import org.remotetech.types.ModelObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.List;

/**
 * User: greg
 * Date: 28/04/13
 * Time: 1:35 PM
 */
@Component
public class JavaGenerator implements CodeGenerator {

    private FileLocationService fileLocationService = new FileLocationService("java/");

    @Autowired
    private JavaImportsAndPackageGenerator javaImportsAndPackageGenerator;

    public void generateCode(List<ModelObject> modelObjects){
        final STGroup stGroup = new STGroupFile("templates/javaClass.stg");

        for (ModelObject modelObject : modelObjects) {
            fileLocationService.createFolder(modelObject.getClassPath());
            final ST clazz = stGroup.getInstanceOf("class");

            clazz.add("modelObject", modelObject);
            clazz.add("package", javaImportsAndPackageGenerator.getPackageString(modelObject));
            clazz.add("imports", javaImportsAndPackageGenerator.buildJavaImportStringList(modelObject));

            fileLocationService.createFile(modelObject.getClassPath(),clazz.render(),modelObject.getClassName() + ".java");
        }
    }


}
