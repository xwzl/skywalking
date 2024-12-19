package com.example.skywalking.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xuweizhi
 * @since 2024-12-19 19:59
 */
@Slf4j
@RestController
@Data
@RequestMapping("/skywalking")
public class SkyWalkingController {

    private static final Logger log = LoggerFactory.getLogger(SkyWalkingController.class);

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @GetMapping("/threadPool")
    public void threadPool() {
        Thread thread = Thread.currentThread();
        log.info("外部线程");

        // 提交任务到线程池
        Future<?> future = executorService.submit(() -> {
            log.info("内部线程");
        });
    }


    // http://localhost:8080/api/skywalking/serviceA
    @GetMapping("/serviceA")
    public String serviceA() {
        RestTemplate restTemplate = new RestTemplate();
        log.info("serviceA");
        String url = "http://localhost:8080/api/skywalking/serviceB";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return "{\"x\":\"s\"}";
    }

    @GetMapping("/serviceB")
    public String serviceB(HttpServletRequest httpServletRequest) {
        String s1 = TraceContext.traceId();
        log.info("serviceB");
        return "";
    }

}
