package br.gov.fa7.cursoejb.exercicio6;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless (name="EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

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
}
