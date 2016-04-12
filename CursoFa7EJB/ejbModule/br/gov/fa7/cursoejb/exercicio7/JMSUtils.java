package br.gov.fa7.cursoejb.exercicio7;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

public class JMSUtils {
	public static void publishMessage(Queue queue, ConnectionFactory connFactory, Serializable obj)
			throws JMSException {
		Connection conn = connFactory.createConnection();
		try {
			Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE); //Java EE 6
			MessageProducer producer = session.createProducer(queue);
			ObjectMessage objMessage = session.createObjectMessage();
			objMessage.setObject(obj);
			producer.send(objMessage);
		} finally {
			conn.close(); // fecha a conexão
		}
	}
}
