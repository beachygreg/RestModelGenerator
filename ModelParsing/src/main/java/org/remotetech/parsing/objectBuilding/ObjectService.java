package org.remotetech.parsing.objectBuilding;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.remotetech.parsing.parsing.FileParsing;
import org.remotetech.parsing.parsing.VariableService;
import org.remotetech.types.ModelList;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 10:08 PM
 */
@Service
public class ObjectService {

    @Autowired
    private FileParsing fileParsing;

    @Autowired
    private VariableService variableService;

    /**
     * creates the model objects without the variables.
     * @param modelFile
     * @param standardModelVariables
     * @return A model object without variables.
     */
    public ModelObject createModelObject(File modelFile, Map<String, ModelVariableType> standardModelVariables){
        final ModelObject modelObject = new ModelObject();
        modelObject.setClassPath(fileParsing.getClassDirectory(modelFile));
        modelObject.setClassName(fileParsing.getClassName(modelFile));
        modelObject.setVariables(variableService.getClassVariables(modelFile, standardModelVariables));
        return modelObject;
    }

    public void setPath(ModelObject modelVariableType, List<ModelObject> modelVariableTypes) {
        final ImmutableMap<String, ModelObject> objectModelObjectImmutableMap = Maps.uniqueIndex(modelVariableTypes, new Function<ModelObject, String>() {
            @Override
            public String apply(ModelObject input) {
                return input.getClassName();
            }
        });
        for (ModelVariableType variableType : modelVariableType.getVariables()) {
            if(variableType instanceof ModelObject){
                final ModelObject modelObject = objectModelObjectImmutableMap.get(((ModelObject) variableType).getClassName());
                ((ModelObject) variableType).setClassPath(modelObject.getClassPath());
            } else if (variableType instanceof ModelList){
                final ModelVariableType listType = ((ModelList) variableType).getModelVariableType();
                if (listType instanceof ModelObject) {
                    final ModelObject modelObject = objectModelObjectImmutableMap.get(((ModelObject) listType).getClassName());
                    ((ModelObject) listType).setClassPath(modelObject.getClassPath());
                }
            }
        }
    }
}
