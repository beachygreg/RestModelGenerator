package org.remotetech.modelGenerator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: greg
 * Date: 28/04/13
 * Time: 5:26 PM
 */
public class Generator {

    public static void main(String args[]){
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //TODO get the program to work via arguments...
        final GeneratorService generatorService = appContext.getBean(GeneratorService.class);
        generatorService.generateCode(GenerationLanguage.JAVA, null);
        generatorService.generateCode(GenerationLanguage.RUBY, null);
    }
}
