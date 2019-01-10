package study201901_04;
/**
 * 测试线程并发安全
 * 1.两个线程同时区取豆子(操作同一个变量的数据bean)
 * @author Administrator
 *
 */
public class SynchtonizeDemo01 {
	public static int bean = 30;//豆子数

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			int bean = 0;
			public void run() {
				while (true) {
					bean = getBean();
					Thread.yield();
					System.out.println(this.getName() + ":" + bean);
				}
			}
		};
		Thread t2 = new Thread() {
			int bean = 0;
			public void run() {
				while (true) {
					bean = getBean();
					Thread.yield();
					System.out.println(this.getName() + ":" + bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
	/**
	 * 取豆子
	 * @return
	 * 解决并发安全办法：
	 * 在public后加上synchronized关键字
	 * 使其同步。
	 */
	public static int getBean() {
		if (bean == 0) {
			throw new RuntimeException("没有豆子了.....");
		}
		Thread.yield();
		return bean--;
	}

}
