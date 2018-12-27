package study201812;

import java.util.*;

/*2018年12月18日19:34:43
 * 单词积累：raw 不成熟的，parameterized 参数化的
 * 知识点：HashMap允许使用null作为键值对
 */
public class TestMap {
	public static void main(String[] args) {
		Map m1 = new HashMap();
		m1.put(null, "2");
		m1.put("b", "3");
		m1.put("c", null);
		System.out.print("----" + m1);
	}
}
/*
 * HashTable和HashMap和ConcurrentHashMap的区别
 *
 * HashTable：
 * 		底层数组+链表实现，无论key还是value都不能为null，线程安全，实现线程安全的方式是在修改数据时锁住整个HashTable，效率低，
 * ConcurrentHashMap做了相关优化。
 * 
 * HashMap：
 * 		底层数组+链表实现，可以存储null键和null值，线程不安全，扩容针对整个Map，每次扩容时，原来数组中的元素
 * 依次重新计算存放位置，并重新插入，插入元素后才判断该不该扩容，有可能无效扩容。
 * 
 * ConcurrentHashMap：
 * 		底层采用分段的数组+链表实现，线程安全，是HashTable的替代。
 */
