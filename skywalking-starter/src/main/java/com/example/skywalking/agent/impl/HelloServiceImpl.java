package com.example.skywalking.agent.impl;

import com.example.skywalking.agent.HelloService;

/**
 * @author xuweizhi
 * @since 2024-12-19 20:42
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void say() {
        System.out.println("------------");
    }

    @Override
    public void saySleep() {
        try {
            Thread.sleep(200);
            System.out.println("------------");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
