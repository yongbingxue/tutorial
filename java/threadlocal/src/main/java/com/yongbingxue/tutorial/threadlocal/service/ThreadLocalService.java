package com.yongbingxue.tutorial.threadlocal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ThreadLocalService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "123");

    public String getValue() {
        return this.threadLocal.get();
    }

    public void unload() {
        logger.info("unload");
        this.threadLocal.remove();
    }
}
