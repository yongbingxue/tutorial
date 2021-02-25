package com.yongbingxue.java8.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class ZonedDateTimeTests {
    private static final Logger logger = LoggerFactory.getLogger(ZonedDateTimeTests.class);

    @Test
    void test_before() {
        logger.info("test");
        LocalDateTime localDateTime = LocalDateTime.now();
        logger.info("localDateTime {}", localDateTime);

        ZonedDateTime before = ZonedDateTime.of(localDateTime, ZoneId.of("+01:00"));
        ZonedDateTime after = ZonedDateTime.of(localDateTime.minus(2, ChronoUnit.HOURS), ZoneId.of("-03:00"));

        logger.info("before {}", before);
        logger.info("after {}", after);

        Assertions.assertTrue(before.isBefore(after));
    }

    @Test
    void test_equal() {
        logger.info("test_equal");
        LocalDateTime localDateTime = LocalDateTime.now();
        logger.info("localDateTime {}", localDateTime);

        ZonedDateTime equal1 = ZonedDateTime.of(localDateTime, ZoneId.of("+01:00"));
        ZonedDateTime equal2 = ZonedDateTime.of(localDateTime.minus(2, ChronoUnit.HOURS), ZoneId.of("-01:00"));

        logger.info("equal1 {}", equal1);
        logger.info("equal2 {}", equal2);

        Assertions.assertTrue(equal1.isEqual(equal2));
    }


    @Test
    void test() {
        logger.info("test_equal");
        Instant.ofEpochSecond()
        Instant.now();
    }
}
