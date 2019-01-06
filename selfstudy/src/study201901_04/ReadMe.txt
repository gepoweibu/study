1.java就近调用原则:方法重载，参数个数相同，类型不同，调用方法是没有匹配的参数类型。
	doSome(null)--null为应用类型的默认值。
	若参数为基本类型：优先调用与之差距最小的基本类型方法->byte->short->int->long||float->double
				：若存在包装类，则优先包装类。
	若参数为引用类型：则优先调用最子类类型方法。
	方法：
	doSome(Interger int),doSome(Object o),doSome(Short s),doSome(short s);
--------------------------------------------------------------------------
2.try{}finally{} 可以组合只用。不捕获异常，保证finally中代码的执行。finally不能单独使用。

3.多线程：
	1).继承Thread，重写Run()方法
	2).实现Runnable接口
	注：t.start()只是将线程纳入线程调度，不一定立即执行run()方法。
	3).new Runnable(){run(){}}接口并把接口中的方法实现，即使用匿名内部类创建线程。
	4).和普通线程差不多t.setDaemon(true)设置为后台线程。
		当进程中只剩下守护线程，所有守护线程强制终止。例如GC线程。
	5)Thread.yield()主动让出CPU时间，回到Runnable状态。
4.同步：
	1).方法上声明同步 public synchronized void setSome()
	2).同步代码块 synchronized(this){代码}; 静态方法中不能使用this。
	3).锁对象要求：多个线程看到的必须是同一个对象。
	