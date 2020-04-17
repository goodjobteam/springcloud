package com.feign.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 通过添加fallback即可实现熔断器功能
 *
 *   微服务架构中服务被拆分成多个服务，服务之间可相互调用（RPC），SpringCloud使用Fegin调用，为保障服务高可用性单个服务会部署
 *   集群，由于服务或者网络原因总会导致服务不可100%可用。如果服务出现问题，掉用该服务就会出现拥塞，此时若再有大量请求，servlet
 *   容器中的线程资源也会耗尽，导致服务瘫痪，并且可能导致整个微服务崩溃，所以使用断路器，当调用服务不可用时会快速执行失败，直接返回
 *   固定的字符串来代替响应超时，从而很好的控制了容器的线程阻塞。 Fegin自带熔断器feign.hystrix.enabled=true配置开启然后实现访问接口
 *   编写失败返回值即可。
 *
 *
 */


//@FeignClient(value = "service-hi1"）
@FeignClient(value = "service-hi1",fallback = SchedualServiceHiHystric.class)
interface SchedarServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
