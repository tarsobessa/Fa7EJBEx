package br.gov.fa7.cursoejb.exercicio6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class EmployeeExportText {

	@Test
	public void testGenerateXML() throws NamingException, FileNotFoundException {
		int total = 10000;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < total; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("name", "employee name " + (i + 1));
			item.put("salary", new BigDecimal((Math.random() * 10000)));
			item.put("dayOfBirth", randomStrDate());
			list.add(item);
		}
		new XStream().toXML(list, new FileOutputStream("employee.xml"));
	}

	public String randomStrDate() {
		int day = (int) (Math.random() * 27) + 1;
		int month = (int) (Math.random() * 11) + 1;
		int year = 1985;
		return String.format("%d/%d/%d", day,month,year);
	}

}
