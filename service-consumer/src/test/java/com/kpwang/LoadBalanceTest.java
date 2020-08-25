package com.kpwang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author kpwang
 * @create 2020-08-25 16:47
 */
@SpringBootTest(classes = ServiceConsumerApplication.class)
@RunWith(SpringRunner.class)
public class LoadBalanceTest {
    @Autowired
    private RibbonLoadBalancerClient client;
    @Test
    public void testLoadBalance(){
        for (int i = 0; i <100 ; i++) {
            ServiceInstance instance = this.client.choose("service-provider");
            System.out.println(instance.getHost()+":"+instance.getPort());
        }
    }
}
