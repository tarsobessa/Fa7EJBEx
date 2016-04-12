package br.gov.fa7.cursoejb.exercicio2;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.gov.fa7.cursoejb.exercicio3.Operator;
import br.gov.fa7.cursoejb.exercicio5.InvalidOperationException;

@Stateless(name="CalculatorController")
public class CalculatorControllerImpl implements CalculatorController {

	@EJB (beanName="SumOperator")
	private Operator sumOperator;
	
	@EJB (beanName="SubOperator")
	private Operator subOperator;
	
	@EJB (beanName="MultiplyOperator")
	private Operator multiplyOperator;
	
	@EJB (beanName="DivisionOperator")
	private Operator divisionOperator;
	
	private Map<Character, Operator> operators = new HashMap<Character, Operator>();
	
	@PostConstruct
	public void init(){
		operators.put(sumOperator.getOperation(), sumOperator);
		operators.put(subOperator.getOperation(), subOperator);
		operators.put(multiplyOperator.getOperation(), multiplyOperator);
		operators.put(divisionOperator.getOperation(), divisionOperator);
	}
	
	@Override
	public double performOperation(double operand1, double operand2, char operation) {
		 Operator operator = operators.get(operation);
		 if(operator!=null){
			 return operator.perform(operand1, operand2);
		 }
		 throw new InvalidOperationException("Operação inválida.");
	}

}
