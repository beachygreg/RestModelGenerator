package org.remotetech.parsing;

import org.remotetech.parsing.files.ModelFileService;
import org.remotetech.parsing.objectBuilding.ModelService;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;
import org.remotetech.parsing.objectBuilding.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 9:32 AM
 */
@Service
public class ModelObjectService {

    @Autowired
    private ModelFileService modelFileService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private TypeService typeService;

    public List<ModelObject> generateObjectsFromDirectory(String fileLocation){
        final List<File> modelFiles = modelFileService.getModelFiles(fileLocation);

        final Map<String,ModelVariableType> standardVariableTypes = typeService.getStandardVariableTypes();

        final List<ModelObject> modelClasses = modelService.createModelClasses(modelFiles, standardVariableTypes);

        return modelClasses;
    }
}
