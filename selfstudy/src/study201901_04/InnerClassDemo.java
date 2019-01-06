package study201901_04;

public class InnerClassDemo {

	public static void main(String[] args) {
		final int a=5;
		int b=4;
		Thread t=new Thread(){
			public void run() {
				System.out.println(args);
				System.out.println(a);
				System.out.println(b);
				System.out.println("java1.8 局部内部类引用方法中的局部变量可以不是final的");
			}
		};
		t.start();
	}
	
}
