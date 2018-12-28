package study201812_02;

import java.util.HashSet;

public class SetTest {

	public static void main(String[] args) {
		HashSet<String> set=new HashSet<String>();
		set.add("you");
		set.add("are");
		set.add("lucky!");
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains("you"));
        //------------------------------------------
        System.out.println("---------Test hashCode() method------------------");
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
		
        
	}

}
