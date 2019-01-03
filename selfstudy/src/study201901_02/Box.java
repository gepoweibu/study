package study201901_02;

/**
 * 泛型类，当做一个盒子，能放存取指定类型的对象
 * 
 * @author Administrator
 * @param <T>
 */
public class Box<T> {
	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T getThing() {
		return t;
	}

	public static void main(String[] args) {
		Box<Integer> box = new Box<Integer>();
		box.add(new Integer(4));
		System.out.println(box.getThing());
		Box<String> box2 = new Box<String>();
		box2.add("hello,I am a String.");
		System.out.println(box2.getThing());
	}

}