package study201903_16;

public class SingletonL {
	private static SingletonL instance = null;
	public static SingletonL getInstance() {
		if(instance==null) {
			synchronized (SingletonL.class) {
				if(instance==null) {
					instance=new SingletonL();
				}
			}
		}
	    return instance;
	}

}
