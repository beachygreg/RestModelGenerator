package org.remotetech.codeGeneration.java;

import org.apache.commons.lang.StringUtils;
import org.remotetech.types.ModelList;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * User: greg
 * Date: 28/04/13
 * Time: 12:54 PM
 */
@Service
public class JavaImportsAndPackageGenerator {
    public boolean hasImport(ModelVariableType modelVariableType){
        if(modelVariableType instanceof ModelList) return true;
        if(modelVariableType instanceof ModelObject) return true;
        return false;
    }

    public List<String> getImportString(ModelVariableType modelVariableType){
        if(modelVariableType instanceof ModelList){
            final List<String> imports = new ArrayList<String>();
            imports.add("java.util.List");
            final ModelVariableType modelVariableType1 = ((ModelList) modelVariableType).getModelVariableType();
            if(modelVariableType1 instanceof  ModelObject){
                imports.add(getModelObjectImportString((ModelObject) modelVariableType1));
            }
            return imports;
        }
        if(modelVariableType instanceof ModelObject){
            final String importString = getModelObjectImportString((ModelObject) modelVariableType);
            return Collections.singletonList(importString);
        } else return new ArrayList<String>();
    }

    private String getModelObjectImportString(ModelObject modelVariableType1) {
        final String classPath = modelVariableType1.getClassPath();
        return StringUtils.replace(classPath, "/", ".") + "." + modelVariableType1.getClassName();
    }

    public List<String> getImportStrings(ModelObject modelObject){
        final List<String> strings = new ArrayList<String>();
        for (ModelVariableType modelVariableType : modelObject.getVariables()) {
            if(hasImport(modelVariableType)){
                strings.addAll(getImportString(modelVariableType));
            }
        }
        return strings;
    }

    public String getPackageString(ModelObject modelObject){
        return StringUtils.replace(modelObject.getClassPath(), "/", ".");
    }

}
