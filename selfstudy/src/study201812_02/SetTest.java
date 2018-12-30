package study201812_02;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
/*
 * hashSet结合判定元素是否重复的依据:对象的equals()方法和hashCode()方法是否同时为true
 * 
 * set集合(等同于数学上的集合定义) 无序不可重复 ---特例：TreeSet 集合是有序的
 */

public class SetTest {

	public static void main(String[] args) {
		Set set=new HashSet<String>();
		set.add("you");
		set.add("are");
		set.add("lucky!");
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains("you"));
        //------------------------------------------
        System.out.println("---------Test No Override hashCode() method------------------");
        HashSet<Cell_NoOverrideHashCode> set2=new HashSet<Cell_NoOverrideHashCode>();
		set2.add(new Cell_NoOverrideHashCode(2, 4));
		set2.add(new Cell_NoOverrideHashCode(2, 4));
		System.out.println(set2);
		System.out.println("we can see contains is false");
		System.out.println(set2.contains(new Cell_NoOverrideHashCode(2, 4)));
		System.out.println("--------Test OverRide hashCode() method-----------------------");
		//---------------------------------------------
		HashSet<Cell_OverrideHashCode> set3=new HashSet<Cell_OverrideHashCode>();
		set3.add(new Cell_OverrideHashCode(2, 4));
		set3.add(new Cell_OverrideHashCode(2, 4));
		System.out.println(set3+"----this is set3  and it's can't add repeat element--- ");
		System.out.println("this time contains is true");
		System.out.println(set3.contains(new Cell_OverrideHashCode(2, 4)));
		System.out.println("----------hashmap and hashtable the as hashset------------");
		//------Test TreeSet-------------------------
		System.out.println("-----------Test TreeSet--------------------");
		Set tSet=new TreeSet<String>(set);
		System.out.println("this is TreeSet : "+ tSet +" sorted according to the natural");
		String noticeStr="All elements inserted into the TreeSet must implement the Comparable interface";
		System.out.println(noticeStr);
        
	}

}
