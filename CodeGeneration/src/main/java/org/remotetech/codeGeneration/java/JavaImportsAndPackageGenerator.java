package org.remotetech.codeGeneration.java;

import org.apache.commons.lang.StringUtils;
import org.remotetech.types.ModelList;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * User: greg
 * Date: 28/04/13
 * Time: 12:54 PM
 */
@Service
public class JavaImportsAndPackageGenerator {

    @Autowired
    private ModelObjectImportService modelObjectImportService;

    public boolean hasImport(ModelVariableType modelVariableType){
        if(modelVariableType instanceof ModelList) return true;
        if(modelVariableType instanceof ModelObject) return true;
        return false;
    }

    public List<String> getImportString(ModelVariableType localVariable, ModelObject object){
        if(localVariable instanceof ModelList){
            final List<String> imports = new ArrayList<String>();
            imports.add("java.util.List");
            final ModelVariableType modelVariableType1 = ((ModelList) localVariable).getModelVariableType();
            if(modelObjectImportService.isModelImportRequired(modelVariableType1, object)){
                imports.add(modelObjectImportService.getModelObjectImportString((ModelObject) modelVariableType1));
            }
            return imports;
        }
        if(modelObjectImportService.isModelImportRequired(localVariable, object)){
            final String importString = modelObjectImportService.getModelObjectImportString((ModelObject) localVariable);
            return Collections.singletonList(importString);
        } else return new ArrayList<String>();
    }




    public List<String> buildJavaImportStringList(ModelObject modelObject){
        final List<String> strings = new ArrayList<String>();
        for (ModelVariableType modelVariableType : modelObject.getVariables()) {
            if(hasImport(modelVariableType)){
                strings.addAll(getImportString(modelVariableType, modelObject));
            }
        }
        return strings;
    }

    public String getPackageString(ModelObject modelObject){
        return StringUtils.replace(modelObject.getClassPath(), "/", ".");
    }

}
