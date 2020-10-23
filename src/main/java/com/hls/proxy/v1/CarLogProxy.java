package com.hls.proxy.v1;

import com.hls.proxy.Car;
import com.hls.proxy.Moveable;

/**
 * @Description 聚合 静态代理
 * @Author jackwang
 * @Date 2020-10-20 16:27
 */

public class CarLogProxy implements Moveable {

    private Moveable car;

    public CarLogProxy(Moveable car) {
        this.car = car;
    }

    @Override
    public void move() {
        System.out.println("log start....");
        this.car.move();
        System.out.println("log end....");
    }

    public static void main(String[] args) {
        // 记录日志
        Moveable car = new Car();
        Moveable carLogProxy = new CarLogProxy(car);

        carLogProxy.move();

    }
}
