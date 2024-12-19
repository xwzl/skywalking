package com.example.skywalking.agent;

import com.example.skywalking.agent.impl.HelloServiceImpl;

/**
 * @author xuweizhi
 * @since 2024-12-19 20:43
 */
public class TestDemo {

    // -javaagent:/Users/xuweizhi/Documents/projects/skywalking/java-agent/target/java-agent-1.0-SNAPSHOT.jar
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        helloService.say();
        helloService.saySleep();
    }
}
