package com.hls.proxy.v2;

import com.hls.proxy.Car;
import com.hls.proxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description JDK 动态代理  为什么叫动态代理？ -> 代理类是在内存中动态生成的，不是程序员书写的
 * @Author jackwang
 * @Date 2020-10-20 18:07
 *
 * JDK 动态代理，被代理的类必须是实现接口的，否则JDK不能生成代理类
 */

public class CarTimeProxy {

    public static void main(String[] args) {
        //设置 JDK代理 在内存中产生的代理类保存到文件中
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        final Moveable car = new Car();
        TimeProxyInvocationHandler timeProxyInvocationHandler =  new TimeProxyInvocationHandler(car);

        Object proxyInstance = Proxy.newProxyInstance(car.getClass().getClassLoader(), new Class[]{Moveable.class}, timeProxyInvocationHandler);

        ((Moveable)proxyInstance).move();

        System.out.println(proxyInstance.getClass());
    }
}

class TimeProxyInvocationHandler implements InvocationHandler{
    private Object o;

    public TimeProxyInvocationHandler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        //调用目标对象方法
        Object invoke = method.invoke(o, args);

        long end = System.currentTimeMillis();

        System.out.println("car total run "+ (end -start));
        return invoke;
    }
}