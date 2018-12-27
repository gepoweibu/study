package study201812;

import study201812.TestInterface.int2;

public class Boo implements int2,int4{
	public void show(){
		System.out.print("调用接口2的方法！");
	}

	public void sleep() {
		System.out.print("调用接口4的方法！");
	};
}
