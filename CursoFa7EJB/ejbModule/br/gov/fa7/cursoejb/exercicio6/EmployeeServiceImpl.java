package br.gov.fa7.cursoejb.exercicio6;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.fa7.cursoejb.exercicio7.EmployeeServiceLocal;
import br.gov.fa7.cursoejb.exercicio7.JMSUtils;

@Stateless (name="EmployeeService")
public class EmployeeServiceImpl implements EmployeeService, EmployeeServiceLocal {

	@PersistenceContext
	private EntityManager manager;

	private SimpleDateFormat dateFormat;

	@PostConstruct
	public void init() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}

	@Override
	@Asynchronous
	public void importItems(List<Map<String, Object>> items) {
		if (items != null) {
			for (Map<String, Object> item : items) {
				Employee emp = new Employee();
				emp.setName((String) item.get("name"));
				emp.setSalary((BigDecimal) item.get("salary"));
				try {
					emp.setDayOfBirth(dateFormat.parse((String) item.get("dayOfBirth")));
				} catch (ParseException e) {
					throw new EJBException(e);
				}
				manager.persist(emp);
			}
		}
	}
	
    private static final int MSG_SIZE = 1000; 
	
	@Resource(name="java:/jms/EmployeeImportQueue")
	private Queue employeeQueue;
	
	@Resource (name="java:/JmsXA")
	private ConnectionFactory connFactory;

	@Override
	public void queueImportItems(List<Map<String, Object>> items) throws JMSException {
		if(items!=null){
			do {
				List<Map<String, Object>> subList = new ArrayList<Map<String,Object>>(items.subList(0, Math.min(MSG_SIZE, items.size())));
				items.removeAll(subList);
				JMSUtils.publishMessage(employeeQueue, connFactory, (Serializable) subList);
			} while (!items.isEmpty());
		}
	}

	@Override
	public void importEmployees(List<Map<String, Object>> items) {
		this.importItems(items);
	}
}
