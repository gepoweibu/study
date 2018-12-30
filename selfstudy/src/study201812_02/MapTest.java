package study201812_02;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		testHashMap();
	}
	//HashMap集合测试
	public static Map<String, String> testHashMap(){
		Map<String, String> hmap = new HashMap<String,String>();
		hmap.put("1","one");
		hmap.put("2","two");
		hmap.put("3","three");
		hmap.put("4","four");
		hmap.put("4","the same key can put in and it will replace old element");
		//Map集合可以看做KeySet和ValueSet的合集，只是key合value一一对应。HashMap通过hash表实现k合v的映射。
		//所以遍历Map集合有两种方法：遍历KeySet和遍历EntrySet
		//使用keySet遍历
		Iterator itk=hmap.keySet().iterator();
		System.out.println("-------use keySet traverse hmap set-----------");
		int element = 1;
		while(itk.hasNext()){
			String key=(String) itk.next();//执行next()后指针会加1，要遍历集合循环中只能用一次
			System.out.println("this is "+(element++)+" element : "+key+","+hmap.get(key));
		}
		System.out.println("-------use foreach traverse keyset and get hmap set-----------");
		//通过遍历hashMap中的Key集合，再用key只获取集合中的元素。
		element=1;
		for (String key : hmap.keySet()) {
			System.out.println("this is "+(element++)+" element : "+key+","+hmap.get(key));
		}
		//使用entrySet遍历
		Iterator ite=hmap.entrySet().iterator();//不能直接hmap.iterator()因为是Set继承Collection接口
		while(ite.hasNext()){
			
			System.out.println();
		}
		for (Entry<String, String> entry : hmap.entrySet()) {
			
		}
		return hmap;
	}

}
