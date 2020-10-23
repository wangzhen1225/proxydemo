package com.hls.proxy.v1;

import com.hls.proxy.Car;
import com.hls.proxy.Moveable;

/**
 * @Description 组合代理
 * @Author jackwang
 * @Date 2020-10-22 19:33
 */

public class Test {
    public static void main(String[] args) {
        // 先记录日志，再记录时间
        Moveable car = new Car();

        Moveable carTimeProxy = new CarTimeProxy(car);
        Moveable carLogProxy = new CarLogProxy(carTimeProxy);

        carLogProxy.move();

    }
}
