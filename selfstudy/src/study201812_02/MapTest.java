package study201812_02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * @author Administrator
 * 
 *         Map常用的子类：
 *
 *         1.Hashtable:内部结构是哈希表，是同步的。不支持null作为键和值。----无序集合
 * 
 *         2.HashMap:内部结构是哈希表，不是同步的，支持null作为键和值。---无序 即迭代顺序并不是放置顺序
 * 
 *         3.TreeMap:内部结构是二叉树，不是同步的，支持null作为键和值。---自然排序，key之必须可排序。
 *         
 *         4.LinkedHashMap:内部使用链表实现，不是同步的，支持null作为键和值。----有序，
 *           使用HashMap操作数据结构，使用LinkedList维护插入元素的先后顺序
 * 
 */

public class MapTest {

	public static void main(String[] args) {
		testHashMap();
		testHashTable();
		testTreeMap();
		testLinkedHashMap();
	}

	// HashMap集合测试
	public static Map<String, String> testHashMap() {
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("1", "one");
		hmap.put("2", "two");
		hmap.put("3", "three");
		hmap.put("4", "four");
		hmap.put("4", "the same key can put in and it will replace old element");
		// Map集合可以看做KeySet和ValueSet的合集，只是key合value一一对应。HashMap通过hash表实现k合v的映射。
		// 所以遍历Map集合有两种方法：遍历KeySet和遍历EntrySet
		// 使用keySet遍历
		Iterator<String> itk = hmap.keySet().iterator();
		System.out.println("-------use keySet traverse hmap set-----------");
		int element = 1;
		while (itk.hasNext()) {
			String key = (String) itk.next();// 执行next()后指针会加1，要遍历集合循环中只能用一次
			System.out.println("this is " + (element++) + " element : " + key + "," + hmap.get(key));
		}
		System.out.println("-------use foreach traverse keyset and get hmap set-----------");
		// 通过遍历hashMap中的Key集合，再用key只获取集合中的元素。
		element = 1;
		for (String key : hmap.keySet()) {
			System.out.println("this is " + (element++) + " element : " + key + "," + hmap.get(key));
		}
		// 使用entrySet遍历
		System.out.println("-------use entrySet traverse hmap set--------------");
		Iterator<Entry<String, String>> ite = hmap.entrySet().iterator();// 不能直接hmap.iterator()因为是Set继承Collection接口
		element = 1;
		while (ite.hasNext()) {
			Entry<String, String> entry = (Entry<String, String>) ite.next();
			System.out.println("this is " + (element++) + " element : " + entry.getKey() + "," + entry.getValue());
		}
		System.out.println("-------use foreach traverse entrySet and get hmap set-------");
		element = 1;
		for (Entry<String, String> entry : hmap.entrySet()) {
			System.out.println("this is " + (element++) + " element : " + entry.getKey() + "," + entry.getValue());
		}
		return hmap;
	}
    //HashTable是否有序
	public static void testHashTable(){
		Hashtable<String,String> htable=new Hashtable<String,String>();
		int i=1;
		for (char j ='a' ; j <'z'; j++) {
			htable.put(i+"",j+"");
		}
		System.out.println("只添加了一个元素，而且还是最后一个，说明key值是唯一的： "+htable);
		System.out.println("下面是向hashTable集合添加元素的顺序: ");
		i=1;
		for (char j ='a' ; j <='z'; j++) {
			htable.put((i++)+"",j+"");
			System.out.println("this is " + (i-1) + " element : " +"{"+ (i-1) + "," + j+"}");
		}
		Iterator<Entry<String, String>> ith = htable.entrySet().iterator();//获得entry迭代器
		System.out.println("下面是hashTable集合迭代输出元素的顺序: ");
		int element=1;
		while(ith.hasNext()){
			Entry<String, String> entry = ith.next();
			System.out.println("this is " + (element++) + " element : " +"{"+ entry.getKey() + "," + entry.getValue()+"}");
		}
		System.out.println("-------由此可以看出Hashtable集合是无序的且key值唯一---------");
	}
	//TreeMap集合测试
	public static void testTreeMap(){
		Map<String, String> tmap=new TreeMap<String,String>();
		int i=1;
		for (char j = 'a'; j <= 'z'; j++) {
			tmap.put(i+"", j+"");
		}
		System.out.println("一样是key唯一，新值替换旧值 : "+tmap);
		System.out.println("下面是向TreeMap集合添加元素的顺序: ");
		i=1;
		for (char j ='a' ; j <='z'; j++) {
			tmap.put((i++)+"",j+"");
			System.out.println("this is " + (i-1) + " element : " +"{"+ (i-1) + "," + j+"}");
		}
		Iterator<Entry<String, String>> itt = tmap.entrySet().iterator();//获得entry迭代器
		System.out.println("下面是TreeMap集合迭代输出元素的顺序: ");
		int element=1;
		while(itt.hasNext()){
			Entry<String, String> entry = itt.next();
			System.out.println("this is " + (element++) + " element : " +"{"+ entry.getKey() + "," + entry.getValue()+"}");
		}
		System.out.println("-------由此可以看出TreeMap集合是有序的且key值唯一---------");
		System.out.println("-------上面的排序并不是自然排序，而是String类实现comparable接口的字符串排序规则---------");
		System.out.println("-------TreeMap排序使用的比较规则是元素类型实现的比较规则-------");
		System.out.println("-------下面是修改比较器后的迭代顺序: ");
		Map<String, String> tmap2=new TreeMap<String, String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.valueOf(o1)-Integer.valueOf(o2);
			}
		});
		tmap2.putAll(tmap);
		element=1;
		Iterator<Entry<String, String>> itt2 = tmap2.entrySet().iterator();//获得entry迭代器
		while(itt2.hasNext()){
			Entry<String, String> entry = itt2.next();
			System.out.println("this is " + (element++) + " element : " +"{"+ entry.getKey() + "," + entry.getValue()+"}");
		}
		System.out.println("--------在Map集合中新建比较器时比较的元素是key值，所以比较器的泛型为key值得类型---------");
	}
	//LinkedHashMap集合测试
	public static void testLinkedHashMap(){
		//通过维护一个运行于所有条目的双向链表，LinkedHashMap保证了元素迭代的顺序。该迭代顺序可以是插入顺序或者是访问顺序。
		Map<String, String> lmap=new LinkedHashMap<String,String>();
		System.out.println("------下面是向LinkedHashMap集合添加元素的顺序: ");
		int i=1;
		for(char j= 'a';j <= 'z';j++){
			lmap.put((i++)+"", j+"");
			System.out.println("this is " + (i-1) + " element : " +"{"+ (i-1) + "," + j+"}");
		}
		System.out.println("------下面是向LinkedHashMap集合迭代元素的顺序: ");
		Iterator<Entry<String, String>> itl = lmap.entrySet().iterator();
		int element=1;
		while(itl.hasNext()){
			Map.Entry<String, String> entry = itl.next();
			System.out.println("this is " + (element++) + " element : " +"{"+ entry.getKey() + "," + entry.getValue()+"}");
		}
		System.out.println("------下面是向LinkedHashMap集合迭代逆序输出元素: ");
		ListIterator<Map.Entry<String,String>> listit=
				new ArrayList<Map.Entry<String,String>>(lmap.entrySet()).listIterator(lmap.size());
		element=1;
		while (listit.hasPrevious()) {
			Entry<String, String> e = listit.previous();
			System.out.println("this is " + (element++) + " element : " +"{"+e.getKey()+","+e.getValue()+"}");
		}
	}
}
