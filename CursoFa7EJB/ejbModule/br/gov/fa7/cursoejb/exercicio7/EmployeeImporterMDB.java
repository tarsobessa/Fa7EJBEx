package br.gov.fa7.cursoejb.exercicio7;

import java.util.List;
import java.util.Map;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

//@MessageDriven(activationConfig = {
//		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/EmployeeImportQueue"),
	//	@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class EmployeeImporterMDB implements MessageListener {
	
	@EJB
	private EmployeeServiceLocal employeeService;

	@SuppressWarnings("unchecked")
	public void onMessage(Message message) {
		if(message instanceof ObjectMessage){
			try {
				List<Map<String,Object>> employeeList = 
						(List<Map<String, Object>>) ((ObjectMessage) message).getObject();
				employeeService.importEmployees(employeeList);
			} catch (JMSException e) {
				throw new EJBException(e);
			}
		}
	}

}
