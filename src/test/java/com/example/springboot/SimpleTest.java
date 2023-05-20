package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * <code>SimpleTest</code>
 *
 * @description:
 * @author: Hao Xueqiang
 * @creation: 2023/5/20
 * @version: 1.0
 */
@Slf4j
public class SimpleTest {

    @Test
    public void test(){
        log.info("this is info");
        log.debug("this is debug");
    }
}
