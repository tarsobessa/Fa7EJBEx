package br.gov.fa7.cursoejb.exercicio2;

import static org.junit.Assert.assertEquals;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import br.gov.fa7.cursoejb.exercicio5.InvalidOperationException;
import br.gov.fa7.cursoejb.utils.JNDIUtils;

public class CalculatorControllerTest {
	
	private CalculatorController controller;

	@Before
	public void setup() throws NamingException{
		controller = JNDIUtils.lookup("ejb:CursoFa7/CursoFa7EJB/CalculatorController!br.gov.fa7.cursoejb.exercicio2.CalculatorController");
	}

	@Test
	public void testSum() {
		assertEquals(8, controller.performOperation(4, 4, '+'), 0);
	}
	
	@Test
	public void testDiv() {
		assertEquals(1, controller.performOperation(4, 4, '/'), 0);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDiv0() {
		assertEquals(0, controller.performOperation(4, 0, '/'), 0);
	}
	
	@Test
	public void testSub() {
		assertEquals(0, controller.performOperation(4, 4, '-'), 0);
	}
	
	@Test
	public void testMul() {
		assertEquals(16, controller.performOperation(4, 4, '*'), 0);
	}
	
	@Test(expected=InvalidOperationException.class)
	public void testNoEx() {
		assertEquals(16, controller.performOperation(4, 4, '%'), 0);
	}

}
