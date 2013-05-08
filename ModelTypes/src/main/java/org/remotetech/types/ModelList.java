package org.remotetech.types;

/**
 * User: greg
 * Date: 20/04/13
 * Time: 9:46 AM
 */
public class ModelList extends ModelVariableType {

    private ModelVariableType modelVariableType;

    @Override
    public ModelList clone(){
        final ModelList clone = (ModelList) super.clone();
        modelVariableType.clone();

        return clone;
    }

    public ModelVariableType getModelVariableType() {
        return modelVariableType;
    }

    public void setModelVariableType(ModelVariableType modelVariableType) {
        this.modelVariableType = modelVariableType;
    }

    @Override
    public String getTypeName() {
        return "List";
    }

}
