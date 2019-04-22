package com.jmstest.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/4/21 21:46
 */
public class MyMessageListener implements MessageListener{
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage)message;
        try {
            System.out.println("receive txt msg==="+msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
