package org.remotetech.parsing.objectBuilding;

import com.google.common.collect.Maps;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 10:33 AM
 */
@Service
public class ModelService {


    @Autowired
    private ObjectService objectService;

    public List<ModelObject> createModelClasses(List<File> modelFiles, Map<String, ModelVariableType> classList) {
        final List<ModelObject> modelVariableTypes = new ArrayList<ModelObject>();

        for (File modelFile : modelFiles) {
            final ModelObject modelClass = objectService.createModelObject(modelFile, classList);
            modelVariableTypes.add(modelClass);
        }


        for (ModelObject modelVariableType : modelVariableTypes) {
            objectService.setPath(modelVariableType, modelVariableTypes);
        }

        return modelVariableTypes;
    }

}
