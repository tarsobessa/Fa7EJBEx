package br.gov.fa7.cursoejb.exercicio1;

import javax.ejb.Remote;

@Remote
public interface EchoService {

	public String echo(String text);
}
