package com.hls.proxy.v4;

import com.hls.proxy.Moveable;
import net.sf.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description TODO
 * @Author jackwang
 * @Date 2020-10-21 19:20
 */

public class AOPTest {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,".");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.hls.proxy.**");
        Object car = annotationConfigApplicationContext.getBean("car");
        System.out.println(car.getClass());
        ((Moveable)car).move();

    }
}
