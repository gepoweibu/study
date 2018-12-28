package study201812_01;

import study201812_01.TestInterface.int1;

public class Aoo implements int1,int3 {
	public void show(){
		System.out.print("调用接口1的方法！");
	}
	public void sleep() {
		System.out.print("调用接口3的方法！");
	};
}
