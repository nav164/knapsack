package com.assignment.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RequestResponseLoggerAspect {

	private static final Logger log = LogManager.getLogger();

	@Around("@annotation(RequestResponseLogger)")
	public Object logAfter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		CodeSignature signature = (CodeSignature) proceedingJoinPoint.getSignature();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < proceedingJoinPoint.getArgs().length; i++) {
			String parameterName = signature.getParameterNames()[i];
			builder.append(parameterName);
			builder.append(": ");
			builder.append(proceedingJoinPoint.getArgs()[i].toString());
			builder.append(", ");
		}
		log.debug("Request body {}", builder);
		Object result = proceedingJoinPoint.proceed();
		log.debug("Method Return value {}" , result);
		return result;
	}
}
