package study201901_02;

public class Generics {

	public static void main(String[] args) {
		// 错误示范:参数类型不能使用char[]
		// char[] cArray = new char[10];
		// for (int i = 0; i < cArray.length; i++) {
		// cArray[i]+='a';
		// }
		// printArray(cArray);
		// 使用包装类解决问题
		Character[] chArray = new Character[10];
		for (int i = 0; i < chArray.length; i++) {
			chArray[i] = (char) ('a' + i);
		}
		printArray(chArray);
		// 输出Integer数组元素
		Integer[] intArray = new Integer[20];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = 10 + i;
		}
		printArray(intArray);
		//测试有界参数类型
		System.out.println("maxNum(1, 2, 3)=="+maxNum(1, 2, 3)+" 输出正确结果:jvm自动装箱转化为Integer类型");
		//System.out.println("因为Integer是引用类型,继承Comparable接口，能调用compareTo()方法");
		System.out.print("maxNum(new Integer(1),new Integer(2),new Integer(3))==");
		System.out.println(maxNum(new Integer(1),new Integer(2),new Integer(3)));
		System.out.println("maxNum('A', 'a', 'o')=="+maxNum('A', 'a', 'o')+" 看来char也进行了自动装箱");
	}

	/**
	 * 泛型方法必须有类型参数声明，放在返回类型前。比如下面的<E>,E可用其他字符替换，比如<T>
	 * 类型参数只能使用引用类型，不能使用原始类型如int，double，char(可使用其包装类型)
	 * @param inputArray
	 * 		     任意引用类型的数组
	 */
	public static <E> void printArray(E[] inputArray) {
		for (E element : inputArray) {
			System.out.printf("%s", element);
		}
		System.out.println();// 换行
		System.out.println("-----数组元素输出完毕-----");
	}
	/**
	 * 有界类型参数：限制参数的类型
	 * 以下方法类型参数声明要求参数的类型必须实现类Comparable接口，<br>即要求对象可调用compareTo()方法。
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 * 		  返回最大值，类型为出入方法的参数类型T
	 */
	public static <T extends Comparable<T>> T maxNum(T x,T y,T z){
		T max=x;//初始假设x最大
		if(x.compareTo(max)>0){
			max=y;
		}else if(y.compareTo(max)>0){
			max=z;
		}
		return max;
	} 
	
}
