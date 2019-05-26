package com.zl.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient
@RestController
public class EurekaclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaclientApplication.class, args);
    }

    @Value("${server.port}")
    String port;
    @Autowired
    DiscoveryClient eurekaClient;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> list = eurekaClient.getServices();
        System.out.println("list: " + list);
        List<ServiceInstance> instanceList = eurekaClient.getInstances("eureka-client");
        for (ServiceInstance instance : instanceList) {
            System.out.println("id: " + instance.getServiceId());
            System.out.println("host: " + instance.getHost());
            System.out.println("port: " + instance.getPort());
            System.out.println("uri: " + instance.getUri());

        }
        return this.eurekaClient;
    }
}
