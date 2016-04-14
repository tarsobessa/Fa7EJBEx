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
	/**
	 * Publica uma mensagem JMS na fila <code>queue</code> usando como
	 * Connection Factory o argumento <code>connFactory</code>
	 * 
	 * @param queue
	 *            fila para a publicação.
	 * @param connFactory
	 *            connection factory usada na publicação.
	 * @param obj
	 *            Objeto a ser publicado como mensagem
	 * @throws JMSException
	 */
	public static void publishMessage(Queue queue, ConnectionFactory connFactory, Serializable obj)
			throws JMSException {
		Connection conn = connFactory.createConnection();
		try {
			Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE); // Java EE 6
			MessageProducer producer = session.createProducer(queue);
			ObjectMessage objMessage = session.createObjectMessage();
			objMessage.setObject(obj);
			producer.send(objMessage);
		} finally {
			conn.close(); // fecha a conexão
		}
	}
}
