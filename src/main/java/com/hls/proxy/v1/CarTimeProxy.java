package com.hls.proxy.v1;

import com.hls.proxy.Car;
import com.hls.proxy.Moveable;

/**
 * @Description 聚合，静态代理  ； 为什么不使用继承 ？ 为什么叫静态代理 ？
 * @Author jackwang
 * @Date 2020-10-20 16:07
 */

public class CarTimeProxy implements Moveable {

    private Moveable car;

    public CarTimeProxy(Moveable car) {
        this.car = car;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();

        this.car.move();

        long end = System.currentTimeMillis();
        System.out.println("car total run "+ (end -start));
    }

    public static void main(String[] args) {
        Car car = new Car();
        CarTimeProxy carTimeProxy = new CarTimeProxy(car);
        carTimeProxy.move();
    }
}
