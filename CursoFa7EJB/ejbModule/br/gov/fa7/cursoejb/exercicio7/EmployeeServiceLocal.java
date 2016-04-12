package br.gov.fa7.cursoejb.exercicio7;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface EmployeeServiceLocal {
	public void importEmployees(List<Map<String,Object>> items);
}
