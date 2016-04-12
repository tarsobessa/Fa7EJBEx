package br.gov.fa7.cursoejb.exercicio1;

import org.junit.Assert;

import javax.naming.NamingException;

import org.junit.Test;

import br.gov.fa7.cursoejb.utils.JNDIUtils;

public class EchoServiceImplTest {

	@Test
	public void testEcho() throws NamingException {
		EchoService service = JNDIUtils.lookup("ejb:CursoFa7/CursoFa7EJB/EchoService!br.gov.fa7.cursoejb.exercicio1.EchoService");
		String echo = service.echo("hello");
		Assert.assertEquals("hello", echo);
	}
	
	

}
