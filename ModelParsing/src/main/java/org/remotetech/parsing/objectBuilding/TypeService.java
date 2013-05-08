package org.remotetech.parsing.objectBuilding;

import org.remotetech.types.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * User: greg
 * Date: 21/04/13
 * Time: 10:28 PM
 */
@Service
public class TypeService {

    public Map<String, ModelVariableType> getStandardVariableTypes(){
        final HashMap<String, ModelVariableType> stringModelVariableTypeHashMap = new HashMap<String, ModelVariableType>();
        stringModelVariableTypeHashMap.put(new ModelFloatingPoint().getTypeName(), new ModelFloatingPoint());
        stringModelVariableTypeHashMap.put(new ModelInteger().getTypeName(), new ModelInteger());
        stringModelVariableTypeHashMap.put(new ModelList().getTypeName(), new ModelList());
        stringModelVariableTypeHashMap.put(new ModelString().getTypeName(), new ModelString());

        return stringModelVariableTypeHashMap;
    }
}
