package com.jmstest.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageConsumer;
import org.apache.activemq.RedeliveryPolicy;

import javax.jms.*;

public class QueueReceiver {
	public static void main(String[] args) throws Exception {
		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		
		RedeliveryPolicy policy = new RedeliveryPolicy();
		policy.setMaximumRedeliveries(3);
		cf.setRedeliveryPolicy(policy);
		
		Connection connection = cf.createConnection();
		connection.start();

		/*
		connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE)，第一个参数表示是否启用事务，第二个
		 参数表示使用哪种应答模式，如果启用事务，则应答模式参数无效，可以随便填。它会在事务被提交的时候，自动确认消息。
		如果不启用事务：
		2、当选择 AUTO_ACKNOWLEDGE应答模式，即connection.createSession(Boolean.False,Session.AUTO_ACKNOWLEDGE)时，
		当客户成功的从receive方法返回的时候，或者从MessageListener.onMessage方法成功返回的时候，会话自动确认客户收到的消息
		3、当选择CLIENT_ACKNOWLEDGE应答模式，即connection.createSession(Boolean.FALSE,Session.CLIENT_ACKNOWLEDGE)时，
		 客户端通过调用消息的acknowledge方法确认消息。
		*/
		final Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("my-queue");

		ActiveMQMessageConsumer consumer = (ActiveMQMessageConsumer)session.createConsumer(destination);

		int i = 0;
		while (i < 3) {
//			TextMessage message = (TextMessage) consumer.receive();

			MapMessage mapMessage= (MapMessage) consumer.receive();
//			System.out.println("收到消 息：" + message.getText());
			System.out.println("收到消息：property:"+mapMessage.getStringProperty("extra"+i)+
			",值："+mapMessage.getString("message--8"+i));

//			if (i==2){
//				mapMessage.acknowledge();
//			}
			i++;
			
//			session.commit();
		}
		session.close();
		connection.close();
	}

}
