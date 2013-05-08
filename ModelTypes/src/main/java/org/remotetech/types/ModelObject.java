package org.remotetech.types;

import java.util.ArrayList;
import java.util.List;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 9:33 AM
 */
public class ModelObject extends ModelVariableType {
    private String className;
    private List<ModelVariableType> variables = new ArrayList<ModelVariableType>();
    private String classPath;

    @Override
    public ModelObject clone(){
        final ModelObject clone = (ModelObject) super.clone();
        clone.setVariables(new ArrayList<ModelVariableType>(variables));
        return clone;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ModelVariableType> getVariables() {
        return variables;
    }

    public void setVariables(List<ModelVariableType> variables) {
        this.variables = variables;
    }

    @Override
    public String getTypeName() {
        return className;
    }


}
