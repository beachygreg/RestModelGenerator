package org.remotetech.codeGeneration.java;

import org.apache.commons.lang.StringUtils;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;
import org.springframework.stereotype.Service;

/**
 * User: greg
 * Date: 9/05/13
 * Time: 6:42 AM
 */
@Service
public class ModelObjectImportService {

    public String getModelObjectImportString(ModelObject modelVariableType1) {
        final String classPath = modelVariableType1.getClassPath();
        return StringUtils.replace(classPath, "/", ".") + "." + modelVariableType1.getClassName();
    }


    public boolean isModelImportRequired(ModelVariableType modelVariableType, ModelObject object) {
        if(modelVariableType instanceof ModelObject ){
            return !StringUtils.equals(((ModelObject) modelVariableType).getClassPath(), object.getClassPath());
        }
        return false;
    }
}
