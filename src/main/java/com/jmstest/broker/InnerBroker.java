package com.jmstest.broker;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URI;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/4/16 21:02
 */
public class InnerBroker {
    public static void main(String[] args) throws Exception {
        //方法一：
//        BrokerService brokerService=new BrokerService();
//        brokerService.setUseJmx(true);
//        brokerService.addConnector("tcp://localhost:61616");
//        brokerService.start();

        //方法二：
//        String Uri = "properties:broker.properties";
//        BrokerService broker1 = BrokerFactory.createBroker(new URI(Uri));
//        broker1.addConnector("tcp://localhost:61616");
//        broker1.start();

        ApplicationContext acx=new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
