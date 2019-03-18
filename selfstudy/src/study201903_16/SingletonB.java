package study201903_16;

public class SingletonB {
	/**
	 * 饱汉式单例静态属性
	 */
    private final static SingletonB singleton_Instance=new SingletonB();
    /**
     * 获取饱汉式单例类实例
     * @return
     */
    public static SingletonB getInstance() {
    	return singleton_Instance;
    }
}
