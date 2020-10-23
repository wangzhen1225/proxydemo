package com.hls.proxy.v3;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @Description CGLIB 代理
 * @Author jackwang
 * @Date 2020-10-21 09:10
 *
 * CGlib代理  对于被代理类来说没有任何限制，因为CGLIB是通过继承被代理类来生成代理的。需要注意的是 被代理类如果是final 修饰或者 被代理类的方法是被final修饰的话，则也无法生成代理类
 */

public class CarTimeProxy {

    public static void main(String[] args) {
        //设置CGlib在内存中生成的代理类到指定目录
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,".");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Bird.class);
        enhancer.setCallback(new TimeProxyCallBack());
        Object o = enhancer.create();

        ((Bird)o).fly();

        System.out.println(o.getClass());
    }

}

class Bird{
    void fly(){
        System.out.println("bird is flying....");
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TimeProxyCallBack implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();

        //调用目标对象的方法
        Object o1 = methodProxy.invokeSuper(o, objects);

        long end = System.currentTimeMillis();

        System.out.println("bird total fly "+ (end -start));
        return o1;
    }
}
