package org.remotetech.codeGeneration.ruby;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang.StringUtils;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: greg
 * Date: 13-05-14
 * Time: 3:05 PM
 */
@Service
public class RubyFormattingService {


    private static final String RUBY_MODULE_SEPARATOR = "::";

    public String createModuleString(ModelObject modelObject){
        String classPath = modelObject.getClassPath();

        String[] split = StringUtils.split(classPath, "/");
        List<String> strings = new ArrayList<String>();
        for (String s : split) {
            strings.add(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, s));
        }

        return StringUtils.join(strings, RUBY_MODULE_SEPARATOR);

    }

    public List<String> createVariableNameList(ModelObject modelObject) {
        ArrayList<String> strings = new ArrayList<String>();

        for (ModelVariableType modelVariableType : modelObject.getVariables()) {
            strings.add(modelVariableType.getVariableName());
        }

        return strings;
    }
}
