package com.jmstest.topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageConsumer;
import org.apache.activemq.RedeliveryPolicy;

import javax.jms.*;

public class NoPersisentReceiver {
	public static void main(String[] args) throws Exception {
		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		
		RedeliveryPolicy policy = new RedeliveryPolicy();
		policy.setMaximumRedeliveries(3);
		cf.setRedeliveryPolicy(policy);
		
		Connection connection = cf.createConnection();
		connection.start();

		final Session session = connection.createSession(Boolean.TRUE,
				Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createTopic("myTopic");

		MessageConsumer consumer = session.createConsumer(destination);


		Message message = consumer.receive();
		while(message!=null) {
			TextMessage txtMsg = (TextMessage)message;
			System.out.println("收到消息：" + txtMsg.getText());
			message = consumer.receive(1000L);
		}

		session.close();
		connection.close();
	}

}
