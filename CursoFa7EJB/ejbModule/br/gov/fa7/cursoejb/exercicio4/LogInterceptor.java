package br.gov.fa7.cursoejb.exercicio4;

import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {
	
	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception{
		
		String methodName = ctx.getMethod().getName();
		String className = ctx.getMethod().getDeclaringClass().getName();
		
		System.out.println(String.format("[%s][entrada] %s.%s", new Date(), className, methodName));
		Long initialTime = System.currentTimeMillis();
		
		Object result = ctx.proceed();
		
		Long finalTime = System.currentTimeMillis();
		System.out.println(String.format("[%s][saída] %s.%s [tempo: %d ms]", new Date(), className,methodName,finalTime-initialTime));
		
		return result;
	}

}
