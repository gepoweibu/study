package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {
	public Object log(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("---this is start log---"+jp.getSignature().getName());
		Object obj = jp.proceed();
		System.out.println("---this is end log---"+jp.getSignature().getName());
		return obj;
	}
	
}
