package br.gov.fa7.cursoejb.exercicio3;

import javax.ejb.Stateless;

@Stateless (name="DivisionOperator")
public class DivisionOperatorImpl implements Operator {

	@Override
	public double perform(double operand1, double operand2) {
		if(operand2<=0){
			throw new ArithmeticException("Não se pode dividir por zero");
		}
		return operand1/operand2;
	}

	@Override
	public char getOperation() {
		return '/';
	}

}
