package study201812_02;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
		hmap.put("4","the same key can't put in");
		//Map集合可以看做KeySet和ValueSet的合集，只是key合value一一对应。HashMap通过hash表实现k合v的映射。
		//所以遍历Map集合有两种方法：遍历KeySet和遍历EntrySet
		//使用keySet遍历
		Iterator itk=hmap.keySet().iterator();
		System.out.println("use keySet traverse hmap set :");
		int element = 1;
		while(itk.hasNext()){
			System.out.println("this is "+(element++)+" element : "+itk.next());
		}
		
		//使用entrySet遍历
		Iterator ite=hmap.entrySet().iterator();//不能直接hmap.iterator()因为是Set继承Collection接口
		while(ite.hasNext()){
			
		}
		for (Entry<String, String> entry : hmap.entrySet()) {
			
		}
		return hmap;
	}

}
