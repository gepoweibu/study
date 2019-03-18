package study201903_16;

public class SingletonJ {
	private static class SingletonInstance{
		private final static SingletonJ instance=new SingletonJ(); 
	}
	public static SingletonJ getInstance() {
		return SingletonInstance.instance;
	}
}
