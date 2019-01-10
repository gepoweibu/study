package study201901_04;

public class ThreadDemo03 {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("开始下载图片...");
				for (int i = 1; i <= 100; i++) {
					System.out.println("图片下载完成：" + i + "%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("图片下载完成================");
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("等待图片下载完成....");
				try {
					t1.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				for (int i = 1; i <= 100; i++) {
					System.out.println("图片显示完成：" + i + "%");
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("图片显示完成===============");
			}
		};
		t1.start();
		t2.start();
	}
}
