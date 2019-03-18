package study201903_16;

public class Fac {
  public static void main(String[] args) {
	  System.out.println("压栈效果：后进先出/先进后出");
	  fc(1237);
	  System.out.println("-----年龄递归-------");
	  System.out.println(fc2(8));
  }
  public static void fc(long n) {
	  System.out.println(n);
	  if(n<=5000) {
		  fc(2*n);  
	  }
	  System.out.println(n);
  }
  public static int fc2(int n) {
	  if(n==1) {
		  return 10;
	  }else {
		  return fc2(n-1)+2;
	  }
  }
}
