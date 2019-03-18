package study201901_07;

public class TestReturnAndFinally {

	public static void main(String[] args) {
		System.out.println(TestRAF());
	}
	public static int TestRAF() {
		try {
			System.out.println("执行try...");
			int a = 10,b =0;
			return a/b;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("执行finally中的代码...");
		}
		return -1;
	}

}
