package com.jmstest.topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;

import javax.jms.*;

public class PersisentReceiver {
	//TODO 持久化订阅消费者
	public static void main(String[] args) throws Exception {
		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		Connection connection = cf.createTopicConnection();
		connection.setClientID("cc1");

		final Session session = connection.createSession(Boolean.TRUE,
				Session.AUTO_ACKNOWLEDGE);

		Topic topic = session.createTopic("myTopic");

		TopicSubscriber comsumer = session.createDurableSubscriber(topic, "t1");
		connection.start();

		Message message = comsumer.receive();
		while(message!=null) {
			TextMessage txtMsg = (TextMessage)message;
			System.out.println("收到消息：" + txtMsg.getText());
			message = comsumer.receive(1000L);
		}

		session.close();
		connection.close();
	}

}
