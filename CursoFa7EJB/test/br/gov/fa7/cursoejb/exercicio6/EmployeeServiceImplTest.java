package br.gov.fa7.cursoejb.exercicio6;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.gov.fa7.cursoejb.utils.JNDIUtils;

public class EmployeeServiceImplTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testImportItems() throws NamingException {
		EmployeeService employeeService = JNDIUtils.lookup("ejb:CursoFa7/CursoFa7EJB/EmployeeService!br.gov.fa7.cursoejb.exercicio6.EmployeeService");
		employeeService.importItems((List<Map<String, Object>>) new XStream().fromXML(new File("employees.xml")));
	}
}
