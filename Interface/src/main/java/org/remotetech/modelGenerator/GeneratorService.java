package org.remotetech.modelGenerator;

import org.apache.commons.lang.StringUtils;
import org.remotetech.codeGeneration.GenerationException;
import org.remotetech.codeGeneration.java.JavaGenerationService;
import org.remotetech.parsing.ModelObjectService;
import org.remotetech.types.ModelObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: greg
 * Date: 28/04/13
 * Time: 5:38 PM
 */
@Service
public class GeneratorService {
    @Autowired
    private ModelObjectService modelObjectService;

    @Autowired
    private JavaGenerationService javaGenerationService;

    public void generateCode(GenerationLanguage language, String modelsSource){
        final List<ModelObject> modelObjects = modelObjectService.generateObjectsFromDirectory(StringUtils.defaultIfBlank(modelsSource, "./models"));

        switch (language) {
            case JAVA:
                javaGenerationService.generateJavaCode(modelObjects);
                break;
            default:
                throw new GenerationException("This language does not exist, feel free to add it to our project on git hub." );
        }
    }
}
