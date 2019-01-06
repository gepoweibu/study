package study201901_04;

public class ThreadDemo01 {

	public static void main(String[] args) {
		MyThread01 t1=new MyThread01();
		MyThread02 t2=new MyThread02();
		t1.start();
		//t2.run();//不能这样调用(这相当于主线程Thread在调用而不是t2线程)
		Thread t3=new Thread(t2);
		t3.start();//这样才是正确纳入线程调度，开启线程
		//匿名内部类差创建线程
		Thread t4=new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					System.out.println("使用匿名内部类创建的线程");
				}
			}
		});
		t4.start();
	}

}
class MyThread01 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i <1000; i++) {
			System.out.println("你是谁啊？");
		}
	}
}
class MyThread02 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i <1000; i++) {
		System.out.println("我是查水表的。");
		}
	}
}