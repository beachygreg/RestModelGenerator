package org.remotetech.types.service;

import org.remotetech.types.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * User: greg
 * Date: 21/04/13
 * Time: 10:28 PM
 */
public class TypeService {
    /**
     * We could use annotate these classes and use spring or aop to do this but is seems like to much work...
     * So just going to do it like this for now.
     */
    public Map<String, ModelVariableType> getStandardVariableTypes(){
        final HashMap<String, ModelVariableType> stringModelVariableTypeHashMap = new HashMap<String, ModelVariableType>();
        stringModelVariableTypeHashMap.put(new ModelFloatingPoint().getTypeName(), new ModelFloatingPoint());
        stringModelVariableTypeHashMap.put(new ModelInteger().getTypeName(), new ModelInteger());
        stringModelVariableTypeHashMap.put(new ModelList().getTypeName(), new ModelList());
        stringModelVariableTypeHashMap.put(new ModelString().getTypeName(), new ModelString());
        stringModelVariableTypeHashMap.put(new ModelBoolean().getTypeName(), new ModelBoolean());
        stringModelVariableTypeHashMap.put(new ModelDate().getTypeName(), new ModelDate());
        return stringModelVariableTypeHashMap;
    }
}
