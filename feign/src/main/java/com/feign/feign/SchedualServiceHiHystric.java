package com.feign.feign;

import feign.Feign;
import feign.Target;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

//将该类注入到Spring  当调用的服务 异常的时候就会自动切换到执行该方法。
@Component
public class SchedualServiceHiHystric implements SchedarServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

}
