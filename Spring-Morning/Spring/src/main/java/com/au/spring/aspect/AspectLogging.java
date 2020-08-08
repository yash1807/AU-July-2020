package com.au.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectLogging {
	
	@Around("aroundCall()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("Area function started");
		Object result = pjp.proceed();
	    
		System.out.println("Area function executed");
		return result;
	}
	
	@Pointcut("execution(* area(..))")
	public void aroundCall(){}
		
}


