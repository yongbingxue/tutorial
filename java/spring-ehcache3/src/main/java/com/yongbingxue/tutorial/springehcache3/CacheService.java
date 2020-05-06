package com.yongbingxue.tutorial.springehcache3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    private static Logger logger = LoggerFactory.getLogger(CacheService.class);
    private static final String CACHE_NAME = "test-cache";

    private CacheManager cacheManager;
    private Cache<Long, String> testCache;

    @PostConstruct
    public void init() {
        logger.info("init cache");
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
            .withCache(CACHE_NAME,
                CacheConfigurationBuilder
                    .newCacheConfigurationBuilder(Long.class, String.class,
                        ResourcePoolsBuilder.heap(2000)))
            .build();
        cacheManager.init();

        testCache = cacheManager.getCache(CACHE_NAME, Long.class, String.class);
    }

    @PreDestroy
    public void destroy() {
        logger.info("destroy cache");
        if (cacheManager == null) {
            return;
        }
        cacheManager.removeCache(CACHE_NAME);
        logger.info("close cache manager");
        cacheManager.close();
    }

    public String getData(Long id) {
        logger.debug("getData - id: {}", id);
        return testCache.get(id);
    }

    public void setData(Long id, String data) {
        logger.debug("setData - id: {}, data: {}", id, data);
        testCache.put(id, data);
    }

}
