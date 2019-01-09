package study201901_04;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		testLinkedBQ();
	}
	/**
	 * ArrayBlockingQueue测试
	 */
	public static void testArrayBQ(){
		ArrayBlockingQueue<String> abq=new ArrayBlockingQueue<>(10);
		for (char i = 'a'; i < 'a'+10; i++) {
			abq.add(i+"");
		}
		System.out.println("队列的第一个元素："+abq.poll()+" 被移出队列");
		System.out.println("队列的第一个元素："+abq.peek());
		System.out.println("队列的第一个元素："+abq.peek());
		System.out.println("队列的第一个元素："+abq.poll()+" 被移出队列");
		System.out.println("队列的第一个元素："+abq.peek());
		System.out.println("poll会移动第一个元素而peek不会移动元素");
		try {
			abq.put("a");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("使用put("+"a"+"): "+abq+" put()把元素添加到队尾");
		abq.offer("offer");
		System.out.println("使用offer(): "+abq+" offer()也是把元素添加到队尾");
	}
	/**
	 * LinkedBlockingDeque测试
	 */
	public static void testLinkedBQ(){
		LinkedBlockingDeque<String> lbq=new LinkedBlockingDeque<String>(10);
		for (char i = 'a'; i < 'a'+10; i++) {
			lbq.add(i+"");
		}
		System.out.println("检索并移出最后一个元素："+lbq.pollLast());
		
	}
}
