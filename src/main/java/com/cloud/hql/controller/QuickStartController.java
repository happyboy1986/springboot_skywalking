package com.cloud.hql.controller;

import com.cloud.hql.util.RedisHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickStartController {
    private final Logger logger = LoggerFactory.getLogger(QuickStartController.class);

    @Autowired
    private RedisHelper redisHelper;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        logger.info("test start");
        redisHelper.set("foo", "bar");
        return "hello world!";
    }
}
