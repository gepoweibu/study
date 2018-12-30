package study201812_02;

import java.util.ArrayList;

/**
 * List  ArrayList and LinkedList
 * @author Administrator
 *2018年12月28日00:19:48
 *List集合：元素有序可重复---实现方式不同增删查询效率不同
 */
public class LearnList {

	public static void main(String[] args) {
		ArrayList<String> alist=new ArrayList<String>();
		alist.add("I");
		alist.add("am");
		alist.add("a");
		alist.add("dog");
		alist.add("!");
		System.out.println("alist : "+alist);
		System.out.println("alist contains I is : "+alist.contains("I"));
		//思考：为什么字符串"I"的contains为true
		ArrayList<Cell_NoOverrideEquals> alist2=new ArrayList<Cell_NoOverrideEquals>();
		alist2.add(new Cell_NoOverrideEquals(2,3));
		alist2.add(new Cell_NoOverrideEquals(1,3));
		alist2.add(new Cell_NoOverrideEquals(5,3));
		alist2.add(new Cell_NoOverrideEquals(2,3));
		System.out.println("alist2 :"+alist2);
		//自定义的类若没有重写toString方法，则会调用Object累的toString方法，输出的是对象在内存中地址对应的
		//哈希值，可以看做是内存地址。
		//根据输出好像可以看出List集合可以添加重复的对象，但是上面的代码中Cell(2,3)是两个不同的对象
		//那么List判断元素是否重复的依据是什么呢。其实就是equals方法是否为true
		System.out.println("alist2 contains (2,3) is : "+alist2.contains(new Cell_NoOverrideEquals(2,3)));
		//上面的contains方法为false的原因是Cell_NoOverrideEquals类没有重写父类的equals方法，
		//所以调用的是父类的equals方法，其比较的是对象的引用，由于是两个不同的对象，所以引用用==比较的
		//结果为false
		ArrayList<Cell_OverrideEquals> alist3=new ArrayList<Cell_OverrideEquals>();
		alist3.add(new Cell_OverrideEquals(1, 2));
		alist3.add(new Cell_OverrideEquals(9, 2));
		alist3.add(new Cell_OverrideEquals(8, 2));
		System.out.println("alist3 : "+alist3);
		System.out.println("alist3 contains (8,2) is :"+alist3.contains(new Cell_OverrideEquals(8, 2)));
	}

}
