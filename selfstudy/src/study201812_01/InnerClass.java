package study201812_01;

import study201812_01.Mama.Baby;

public class InnerClass {
	public static void main(String[] args) {
		Mama a = new Mama("小红"); // 创建Mama对象
		Baby b = a.create(); // Mama对象创建一个Baby对象
		b.callMama(); // 调用Baby的方法
		System.out.print(b.m.name);
		// 总结：1.不可以外部类中直接new内部累的对象，但是可以通过方发去访问。
		// 2.可以再内部类中创建外部类的对象。
	}
}

class Mama {
	String name;

	Mama(String name) {
		this.name = name;
	}

	Baby create() {
		return new Baby();
	}

	// Baby b = new Baby();//这样不可以，因为还没有Baby类的信息
	class Baby {
		Mama m = new Mama("小花");

		void callMama() {
			System.out.print(name);// 默认隐式指向 Mama.this.name
			// System.out.print(this.name);//错误当前类Baby没有name属性
		}
	}
	// Baby b = new Baby();//一样的错误
}
