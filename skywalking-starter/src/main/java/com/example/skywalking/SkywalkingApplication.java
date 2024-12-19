package com.example.skywalking;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// -javaagent:/Users/xuweizhi/Documents/projects/skywalking/skywalking-agent/skywalking-agent.jar
// -Dskywalking.agent.service_name=emr-osgi-test
// -Dskywalking.collector.backend_service=192.168.110.72:11800
// -Dserver.port=8086
@Slf4j
@SpringBootApplication
public class SkywalkingApplication {

    public static void main(String[] args) {
        log.info("启动");
        SpringApplication.run(SkywalkingApplication.class, args);
    }

}
