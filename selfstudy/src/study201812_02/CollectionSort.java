package study201812_02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author Administrator 
 * eclipse 添加JDK源码的方法 把JDK安装目录下的src.zip添加到jre中jrt.rar文件的
 * source Attachment中: window->Java->installed jre->Edit->jrt.rar->souce
 * attachment->src.zip java.util.Collections util中集合工具类
 * Collections.sourt()方法的使用  集合中的元素实现了comparable接口或使用匿名内部类的
 * 方法新定义comparator比较器。    
 *
 */

public class CollectionSort {

	public CollectionSort() {
	}

	public static void main(String[] args) {
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("age");
		alist.add("you");
		alist.add("good");
		System.out.println("alist is not sorted : " + alist);
		Collections.sort(alist);// 排序，思考排序规则
		System.out.println("alist is sorted :" + alist);
		// 知识点：既然有排序，那肯定比较规则，所以Java中能排序的对象一定实现了Comparable接口
		ArrayList<Emp> alist2 = new ArrayList<Emp>();
		alist2.add(new Emp("jhon", "man", 23, 5000));
		alist2.add(new Emp("selina", "woman", 25, 9000));
		alist2.add(new Emp("jack", "man", 27, 5990));
		alist2.add(new Emp("snow", "man", 30, 8000));
		alist2.add(new Emp("snowkk", "man", 35, 6000));
		// Collections.sort(alist2); //Emp或其父类没有实现Comparable接口所以不能排序。
		// 解决办法：使用匿名内部类添加比较器，用泛型指定比较器的比较类型为Emp
		Collections.sort(alist2, new Comparator<Emp>() {

			@Override
			public int compare(Emp o1, Emp o2) {
				// 比较工资来排序
				return o1.getSalary() - o2.getSalary();
			}
		});
		System.out.println("Sort by salary :");
		for (Emp emp : alist2) {
			System.out.println(emp);
		}
		// 如果集合中的元素实现了comparable接口即可直接排序，若不想使用comparable的比较规则，可以和上面一样使用行的比较器
		ArrayList<Emp2ImpComparable> alist3 = new ArrayList<Emp2ImpComparable>();
		alist3.add(new Emp2ImpComparable("jhon", "man", 23, 5000));
		alist3.add(new Emp2ImpComparable("selina", "woman", 25, 9000));
		alist3.add(new Emp2ImpComparable("jack", "man", 27, 5990));
		alist3.add(new Emp2ImpComparable("snow", "man", 30, 8000));
		alist3.add(new Emp2ImpComparable("snowkk", "man", 35, 6000));
		Collections.sort(alist3);
		System.out.println("Sort by age :");
		for (Emp2ImpComparable emp2 : alist3) {
			System.out.println(emp2);
		}
		Collections.sort(alist3, new Comparator<Emp2ImpComparable>() {
            //根据name比较，若最小name的长度大于等于1则先根据字符的ASCII码来比较，若第一个字符一样则在比较第二个字符，
			//若前面的字符都相同则比较长度。这只String类型中比较两个字符串的方法。
			@Override
			public int compare(Emp2ImpComparable o1, Emp2ImpComparable o2) {
				int len1 = o1.getName().length();
				int len2 = o2.getName().length();
				int lim = Math.min(len1, len2);
				char v1[] = o1.getName().toCharArray();
				char v2[] = o2.getName().toCharArray();
				int k = 0;
				while (k < lim) {
					char c1 = v1[k];
					char c2 = v2[k];
					if (c1 != c2) {
						return c1 - c2;
					}
					k++;
				}
				return len1-len2;
			}
		});
		System.out.println("Sort by name :");
		for (Emp2ImpComparable emp2 : alist3) {
			System.out.println(emp2);
		}

	}

}
