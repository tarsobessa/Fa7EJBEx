package br.gov.fa7.cursoejb.exercicio4;

import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {
	
	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception{
		
		String methodName = ctx.getMethod().getName();
		String className = ctx.getMethod().getDeclaringClass().getName();
		
		System.out.println("["+new Date()+"] [entrada] " + className + "." + methodName);
		Long initialTime = System.currentTimeMillis();
		
		Object result = ctx.proceed();
		
		Long finalTime = System.currentTimeMillis();
		System.out.println("["+new Date()+"] [saída] " + className + "." + methodName + " [tempo: "+(finalTime-initialTime)+" ms]");
		
		return result;
	}

}
