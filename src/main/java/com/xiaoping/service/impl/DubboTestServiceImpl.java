package com.xiaoping.service.impl;

import com.xiaoping.service.DubboTestService;
import org.springframework.stereotype.Service;

@Service
public class DubboTestServiceImpl implements DubboTestService {
    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
