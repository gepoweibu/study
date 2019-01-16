package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;
@Component
//@Aspect//一个切面类可以的定义多个切面方法(自由组合切面和业务spring的优点)
public class AfterAspect {
	//注意匹配条件中的括号...
	@After(value="execution(* service.TestAfterService.*(..))")
	public void testTime(JoinPoint jp) throws Throwable {
		System.out.println("---Hello I am After LogAspect---"+jp.getSignature().getName());
	}
}
