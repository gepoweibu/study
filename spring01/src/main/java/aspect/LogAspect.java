package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect//切面注解
@Component//注册bean
public class LogAspect {
	@Around(value = "execution(* service.PersonService.*(..))")
	public Object log(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("---this is start log---"+jp.getSignature().getName());
		Object obj = jp.proceed();
		System.out.println("---this is end log---"+jp.getSignature().getName());
		return obj;
	}
	@After(value="execution(* service.TestAfterService.*(..))")
	public void testTime(JoinPoint jp) throws Throwable {
		System.out.println("---Hello I am After LogAspect---"+jp.getSignature().getName());
	}
}
