package org.remotetech.parsing.parsing;

import org.remotetech.types.ModelList;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * User: greg
 * Date: 21/04/13
 * Time: 10:18 PM
 */
@Service
public class LineParser {


    public ModelVariableType createVariableForLine(Map<String, ModelVariableType> standardModelVariables, String[] split) {
        if(standardModelVariables.containsKey(split[1])){
            ModelVariableType modelVariableType = getStandardVariableFromLine(standardModelVariables, split);
            modelVariableType.setVariableName(split[0]);
            return modelVariableType;
        } else {
            final ModelObject modelObject  = new ModelObject();
            modelObject.setVariableName(split[0]);
            modelObject.setClassName(split[1]);
            return modelObject;
        }
    }

    public ModelVariableType getStandardVariableFromLine(Map<String, ModelVariableType> standardModelVariables, String[] variableLine) {
        ModelVariableType modelVariableType = standardModelVariables.get(variableLine[1]);
        if(modelVariableType instanceof ModelList){
            final ModelList modelList = new ModelList();
            if(standardModelVariables.containsKey(variableLine[2])){
                modelList.setModelVariableType(standardModelVariables.get(variableLine[2]).clone());
            } else {
                final ModelObject modelObject  = new ModelObject();
                modelObject.setClassName(variableLine[2]);
                modelList.setModelVariableType(modelObject);
            }
            modelVariableType = modelList;
        } else {
            modelVariableType = modelVariableType.clone();
        }
        return modelVariableType;
    }

}