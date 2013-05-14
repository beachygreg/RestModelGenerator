package org.remotetech.codeGeneration;

import org.remotetech.types.ModelObject;

import java.util.List;

/**
 * User: greg
 * Date: 12/05/13
 * Time: 11:02 AM
 */
public interface CodeGenerator {

    void generateCode(List<ModelObject> modelObjects);
}
