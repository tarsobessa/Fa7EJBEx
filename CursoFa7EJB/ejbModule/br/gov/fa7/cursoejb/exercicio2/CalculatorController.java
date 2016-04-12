package br.gov.fa7.cursoejb.exercicio2;

import javax.ejb.Remote;

@Remote
public interface CalculatorController {
	public double performOperation(double operand1, double operand2, char operation);	
}
