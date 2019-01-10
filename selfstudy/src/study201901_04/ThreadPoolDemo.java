package study201901_04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;//线程池工厂类

public class ThreadPoolDemo {

	public static void main(String[] args) {
		ExecutorService tp=Executors.newFixedThreadPool(10);
		Runnable rb=new Runnable() {
			public void run() {
				System.out.println("rb线程正在运行.....");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("rb运行完成!");
			}
		};
		tp.execute(rb);
		tp.shutdown();
	}
}
