package br.gov.fa7.cursoejb.exercicio3;

import javax.ejb.Stateless;

@Stateless (name="MultiplyOperator")
public class MultiplyOperatorImpl implements Operator {

	@Override
	public double perform(double operand1, double operand2) {
		return operand1*operand2;
	}

	@Override
	public char getOperation() {
		return '*';
	}

}
