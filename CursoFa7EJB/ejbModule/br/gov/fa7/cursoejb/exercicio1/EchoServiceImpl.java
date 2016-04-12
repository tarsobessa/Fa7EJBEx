package br.gov.fa7.cursoejb.exercicio1;

import javax.ejb.Stateless;

@Stateless(name="EchoService")
public class EchoServiceImpl implements EchoService {

	@Override
	public String echo(String text) {
		return text;
	}

}
