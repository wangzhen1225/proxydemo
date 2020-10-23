package com.hls.proxy;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Description Moveable 接口的实现类
 * @Author jackwang
 * @Date 2020-10-20 16:07
 */
@Component
public class Car implements Moveable {

    @Override
    public void move() {
        System.out.println("car running....");
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
