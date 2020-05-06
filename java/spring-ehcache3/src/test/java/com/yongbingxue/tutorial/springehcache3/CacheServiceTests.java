package com.yongbingxue.tutorial.springehcache3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { CacheService.class })
class CacheServiceTests {
    private static Logger logger = LoggerFactory.getLogger(CacheServiceTests.class);

    @Autowired
    private CacheService cacheService;

    @Test
    void test() {
        logger.info("test");

        String data = "test1";

        cacheService.setData(1234567L, data);

        Assertions.assertEquals(data, cacheService.getData(1234567L));
    }
}
