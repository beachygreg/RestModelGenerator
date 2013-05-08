package org.remotetech.types;

import com.google.common.base.CaseFormat;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 9:39 AM
 */
public abstract class ModelVariableType implements Cloneable {
    private String variableName;

    public abstract String getTypeName();
    @Override
    public ModelVariableType  clone() {
        final ModelVariableType clone;
        try {
            clone = (ModelVariableType) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("There is an error with one of the variable type classes. Could not clone it...");
        }

        return clone;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName){
        this.variableName = variableName;
    }

    public String getVariableNameUpperCamel(){
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL,this.variableName);
    }
}
