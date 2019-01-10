网络编程练习包:
1.Socket和SeverSocket类的使用练习。
	SayHelloClient和SayHelloServer必须分开运行，不然会报端口被占用的错误。
	解决办法：开两个命令行窗口，一个运行客户端，一个运行服务端。
	从一个cmd窗口打开另一个窗口的命令：start cmd.
2.在eclipse中Run as application(先server后client)，然后new console view。
------------------------------------------------------------
JDK环境变量设置： 用户环境变量只对当前用户起作用，系统环境变量对所有用户起作用。
	系统变量：JAVA_HOME==C:\Program Files (x86)\Java\jdk1.8.0_191
        	CLASSPATH==.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;//.表示当前目录
	Path添加：%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin
--javac Test.java----编译报错--编码GBK的不可映射字符--------------
	解决办法：
 	javac -encoding utf-8 Test.java
 -----------------客户端和服务端在运行前需要设置应用运行参数----------
----run as->run configrations->java application->client.java->arguments
----注意多个参数用空格 隔开即可。
==========指定消息长度==========================================
	Writes the specified byte to this output stream. 
	The general contract for write is that one byte is written to the output stream.
	The byte to be written is the eight low-order bits of the argument b. 
	The 24 high-order bits of b are ignored. 
-------------------------------------------------------------
outputStream.write(int b);把4个字节，32位的b写进输出流，只有参数b的低8位
	会被写进输出流，而高24位(3字节)会被忽略--(以0填充)
	总结：写一个字节的数据到输出流，这个字节的数据取得是int型b的低8位。
================视屏笔记=======================================
1.RandomAccessFile--基于指针的可读可写流，读RandomAccessFile(String filePath,String mode)
	mode="r" 可读，mode="rw" 可读可写。一次读取或写入一个字节。
	raf=getFilePointer()可获取当前指针。

2.对象序列化：把对象特定类型的数据转为二进制数据保存到硬盘中，
	其中保存到硬盘的过程称为对象的持久化。
 	1).用到的流：ObjectInputStream，ObjecOutputStream
	其中ois.readObject()读取序列化对象，oos.writeObject()用于写入序列化对象。
	2).序列化的对象必须实现Serialiazble接口，一般加上serialVersionUid(序列化版本号)
	变与在反序列化对象时若对应的类以改变，反序列化的数据尽量匹配当前类，没有版本号或改变版本号会报错。
	3).tranisent(短暂的)关键字用于标记不需要序列化的属性，反序列化后为默认值。

3.PrintWriter(OutputStream os,Boolean autoFlush)具有自动行刷新功能的缓存输出流。
	若autoFlush=truepw.println(data)之后会自动调用pw.flush()刷新输出流中的数据。
	注：可以一行行的输出，对于文本写入效率较高。
	
4.BufferReader(Reader r) br.readLine() 每次读取一行文本，读到文件末尾返回NULL，
	行读取，处理文本效率较高。
5.uft-8编码中文占3个字节，unionCode编码中文占2个字节，java中使用的是后者。
 	一般使用InputStreamReader(InputStream in,String encoding)
 	或OutputStreamReader(OutputStream out,String encoding)
 	指定流的字符集编码。
	