package br.gov.fa7.cursoejb.exercicio5;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class InvalidOperationException extends RuntimeException {

	private static final long serialVersionUID = -9051032773374157555L;

	public InvalidOperationException(String msg) {
		super(msg);
	}

	public InvalidOperationException(String msg, Throwable t) {
		super(msg, t);
	}

}
