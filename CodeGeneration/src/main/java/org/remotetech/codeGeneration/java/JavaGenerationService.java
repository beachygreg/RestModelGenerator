package org.remotetech.codeGeneration.java;

import org.remotetech.codeGeneration.FileLocationService;
import org.remotetech.types.ModelObject;
import org.springframework.beans.factory.annotation.Autowired;
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
@Service
public class JavaGenerationService {

    private FileLocationService fileLocationService = new FileLocationService("java/");

    @Autowired
    private JavaImportsAndPackageGenerator javaImportsAndPackageGenerator;

    public void generateJavaCode(List<ModelObject> modelObjects){
        final STGroup stGroup = new STGroupFile("javaClass.stg");

        for (ModelObject modelObject : modelObjects) {
            fileLocationService.createPackage(modelObject.getClassPath());
            final ST clazz = stGroup.getInstanceOf("class");

            clazz.add("modelObject", modelObject);
            clazz.add("package", javaImportsAndPackageGenerator.getPackageString(modelObject));
            clazz.add("imports", javaImportsAndPackageGenerator.getImportStrings(modelObject));

            fileLocationService.createFile(modelObject.getClassPath(),clazz.render(),modelObject.getClassName() + ".java");
        }
    }


}
