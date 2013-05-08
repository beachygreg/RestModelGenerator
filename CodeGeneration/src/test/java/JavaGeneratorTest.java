import org.junit.Test;
import org.remotetech.types.ModelInteger;
import org.remotetech.types.ModelList;
import org.remotetech.types.ModelObject;
import org.remotetech.types.ModelVariableType;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * User: greg
 * Date: 27/04/13
 * Time: 8:55 PM
 */
public class JavaGeneratorTest {

    @Test
    public void testGetter(){
        final ModelVariableType modelInteger = new ModelInteger();
        modelInteger.setVariableName("testVar");
        STGroup stGroup = new STGroupFile("javaGetter.stg");
        final ST getter = stGroup.getInstanceOf("getter");
        getter.add("type",modelInteger);

        final String render = getter.render();

        assertThat(render, containsString("public Integer getTestVar(){"));
        assertThat(render, containsString("return this.testVar;"));
        assertThat(render, containsString("}"));
    }

    @Test
    public void testGenerics(){
        final ModelList modelList = new ModelList();
        modelList.setVariableName("intList");
        modelList.setModelVariableType(new ModelInteger());

        STGroup stGroup = new STGroupFile("javaGetter.stg");
        final ST getter = stGroup.getInstanceOf("getter");
        getter.add("type",modelList);

        final String render = getter.render();

        assertThat(render, containsString("public List<Integer> getIntList(){"));
        assertThat(render, containsString("return this.intList;"));
        assertThat(render, containsString("}"));
    }


    @Test
    public void testClassGenerator(){
        STGroup stGroup = new STGroupFile("javaClass.stg");
        final ST clazz = stGroup.getInstanceOf("class");

        final ModelObject modelObject = new ModelObject();
        modelObject.setClassName("Test");
        final ModelInteger modelInteger = new ModelInteger();
        modelInteger.setVariableName("count");

        modelObject.getVariables().add(modelInteger);


        clazz.add("modelObject", modelObject);
        clazz.add("package", "org.remotetech.test");

        final String render = clazz.render();

        assertThat(render, containsString("package org.remotetech.test;"));
        assertThat(render, containsString("public class Test {"));
        assertThat(render, containsString("public Integer getCount(){"));
        assertThat(render, containsString("return this.count;"));
        assertThat(render, containsString("public void setCount(Integer count){"));

    }
}
