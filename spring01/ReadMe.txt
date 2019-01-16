Spring的切面Aspect注解：
1.@Around(value = "execution(* service.PersonService.*(..))")
	public Object log(ProceedingJoinPoint jp) throws Throwable {}
	其中Around注解的方法参数类型必须为ProceedingJoinPoint.其余注解用JoinPoint类型
	执行jp.proceed()时执行目标方法。
2.@After(value="execution(* service.TestAfterService.*(..))")
	匹配方法执行后（不论是否有异常），注解方法最终都执行。
3.@AfterReturning(value="execution(* service.*(..))",returning="result")
    public void afterReturning(JoinPoint point, Object result){}
          匹配方法执行后注解方法执行，若匹配方法出现异常则不执行注解方法。
4.@AfterThrowing(value="execution(* service.*(..))",throwing="exception")
    public void afterReturning(JoinPoint point, Exception exception){}
	匹配方法抛出异常后才执行注解方法。
5. @Before("execution(* service.*(..))")
    public void beforMethod(JoinPoint point){}
          匹配方法之前执行
       
Spring的bean（对象）实例化注解：
	@Compoent 
	@Controller //web层使用
	@Service //业务层使用
	@Repository //持久层使用
	以上四个注解功能都一样，注解不同是为了便于区分业务。
	@Scope(value = "prototype") //原型模式创建对象，默认singleton单例
	//Scope注解配置创建对象是否是以单列模式进行创建
	所有注解不给value值则默认bean的属性name=（第一个字母小写）类名--->[BeanNameGenerator]
Spring的属性注入注解：
	@Autowired根据类型(byType)自动注入(从容器中寻找合适的对象注入)
	@Qualifier("beanName")配合自动注入使用，当一个接口有多个实现时，
	自动注入不确定注入那个实现类对象，则用Qualifier来指定。
	@Resource(name="")指定注入的bean的名称(byName)
Spring切面注解：@Aspect