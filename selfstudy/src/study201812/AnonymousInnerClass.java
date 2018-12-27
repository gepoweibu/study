package study201812;

/*2018年12月19日16:26:51
 * 匿名内部类：
 */
public class AnonymousInnerClass {
	public static void main(String[] args) {
		//int3 i = new int3();//错误，接口不能实例化
		//int3 i = new int3(){};//int3中的方法必须要实现
		int3 i = new int3() {

			@Override
			public void sleep() {
				System.out.print("睡大觉");
			}
		};//必须要有分号
		i.sleep();

	}
}
