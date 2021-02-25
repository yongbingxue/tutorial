package com.yongbingxue.tutorial.threadlocal.controller;

import com.yongbingxue.tutorial.threadlocal.service.ThreadLocalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class ThreadLocalController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ThreadLocalService threadLocalService;

    public ThreadLocalController(ThreadLocalService threadLocalService) {
        this.threadLocalService = threadLocalService;
    }

    @GetMapping
    public void test() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 1; i++) {
            executorService.execute(() -> {
                logger.info("ThreadLocal value:{}", threadLocalService.getValue());
                logger.info("thread:{}", Thread.currentThread().getId());

                threadLocalService.unload();

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("ThreadLocal value:{}", threadLocalService.getValue());
            });
        }

    }
}
