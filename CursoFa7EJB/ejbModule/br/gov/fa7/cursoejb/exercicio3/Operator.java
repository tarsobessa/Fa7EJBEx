package br.gov.fa7.cursoejb.exercicio3;

import javax.ejb.Local;

@Local
public interface Operator {
	double perform(double operand1, double operand2);
	
	char getOperation();
}
