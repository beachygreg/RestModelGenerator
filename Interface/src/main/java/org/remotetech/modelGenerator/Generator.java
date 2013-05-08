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
        //TODO make this dynamic
        final GeneratorService bean = appContext.getBean(GeneratorService.class);
        bean.generateCode(GenerationLanguage.JAVA, null);

    }
}
