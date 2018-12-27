package study201812;

public class TestInterface {

	public static void main(String[] args) {
           Aoo o1 = new Aoo();
           Boo o2 = new Boo();
           o1.show();
           o1.sleep();
           o2.show();
           o2.sleep();
           
	}
	interface int1{   //借口的默认写法
		int PI = 4;
		void show();
	}
	public abstract interface int2{ //接口的完整写法
	    public static final int PI=5;
		public abstract void show();
	}
}
//总结：1.接口可以单独写成一个Java文件(相当于普通类)，也可以写在main方法所在的类中（相当于内部类）。
//     2.接口的修饰词、接口中常量的修饰词和方法的修饰词可以少写或者不写，系统默认接口中只有常量和抽象方法。