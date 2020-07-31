package com.yuvintech.spring.boot.mobile.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LogExecutionTimeAspect {
	
	//Logger log = LoggerFactory.getLogger(LogExecutionTimeAspect.class);
	
	//@Pointcut(value = ("execution(* com.yuvintech.spring.boot.mobile..*.*(..))"))
	//public void logExecutionTimeForAllMethodsPointCut() {}
	
	@Pointcut(value = ("@annotation(com.yuvintech.spring.boot.mobile.aop.LogExecutionTime)"))
	public void logOnlyAnnotatedMethods() {}
	
	
	
	@Around(value = "logOnlyAnnotatedMethods()")
	public Object logExecutionTimeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object returnValue = null;
		try {
			returnValue = joinPoint.proceed();
		} catch (Throwable e) {
			log.error("Exception whil executing "+joinPoint.getSignature().toShortString() , e);
			throw e;
		}
		
		
		log.warn("The Total time taken to execute:: "+joinPoint.getSignature().toShortString()+" is in Millis "
		+(System.currentTimeMillis()-start) );
		
		
		return returnValue;
		
		
		
	}
	

}
