package study201903_16;

public class Cacu {

	public static void main(String[] args) {
		cacu(1037949584736457L);
	}

	public static void cacu(long num) {
		while (num != 0) {
			System.out.println("num: "+num);
			long yu = num % 10L;
			System.out.println("yu: "+yu);
			num /= 10L;
		}
	}

}
