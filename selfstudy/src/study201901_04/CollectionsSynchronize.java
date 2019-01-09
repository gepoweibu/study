package study201901_04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionsSynchronize {

	public static void main(String[] args) {
		Map<String, String> m=new HashMap<String,String>();
		m.put("1", "one");
		m.put("2", "two");
		m.put("3", "three");
		Map<String, String> synchm = Collections.synchronizedMap(m);
		System.out.println(synchm);
	}

}
