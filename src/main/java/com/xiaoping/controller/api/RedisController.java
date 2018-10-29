package com.xiaoping.controller.api;

import com.xiaoping.pojo.Rs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public Rs set(@RequestParam(required = true) String key,
                  @RequestParam(required = true) String val) {

        template.opsForValue().set(key, val);
        return Rs.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Rs get(@RequestParam(required = true) String key) {
        return Rs.ok(template.opsForValue().get(key));
    }
}
