package com.yb;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.print.attribute.standard.PresentationDirection;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/27 0027 14:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //开启
public class CloudHystrixApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(CloudHystrixApplication.class,args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身没有关系，springcloud升级系统后的坑，
     * ServletRegistrationBean因为Springboot的默认路径不是“/hystrix.stream”,
     * 只需要在自己的项目里面配置下面的Servlert就可以
     *
     * hystrix dashboard图形界面监控地址：  http://localhost:8001/hystrix.stream
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;

    }

}
