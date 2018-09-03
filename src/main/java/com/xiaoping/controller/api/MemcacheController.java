package com.xiaoping.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memcache")
public class MemcacheController {

//    @Autowired
//    private MemcachedClient memcachedClient;
//
//
//    @RequestMapping(value = "/set", method = RequestMethod.POST)
//    public Rs set(@RequestParam String key, @RequestParam String val){
//        if(memcachedClient.get(key) != null) {
//            memcachedClient.set(key, 60 * 60 * 24, val);
//        } else{
//            memcachedClient.add(key, 60 * 60 * 24, val);
//        }
//        return Rs.ok();
//    }
//
//    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    public Rs get(@RequestParam String key) {
//
//        return Rs.ok(memcachedClient.get(key));
//    }
//
//    @RequestMapping(value = "/del", method = RequestMethod.POST)
//    public Rs del(@RequestParam String key) {
//
//        return Rs.ok(memcachedClient.delete(key));
//    }
}
