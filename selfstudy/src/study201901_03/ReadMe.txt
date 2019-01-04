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
--javac Test.java----编译报错--编码GBK的不可映射字符---------------------------
解决办法：
 javac -encoding utf-8 Test.java
 -----------------客户端和服务端在运行前需要设置应用运行参数--------------------------
----run as->run configrations->java application->client.java->arguments
----注意多个参数用空格 隔开即可。
==========指定消息长度=============
Writes the specified byte to this output stream. 
The general contract for write is that one byte is written to the output stream.
The byte to be written is the eight low-order bits of the argument b. 
The 24 high-order bits of b are ignored. 
------------------------------------
outputStream.write(int b);把4个字节，32位的b写进输出流，只有参数b的低8位
会被写进输出流，而高24位(3字节)会被忽略--(以0填充)
--总结：写一个字节的数据到输出流，这个字节的数据取得是int型b的低8位。
====================================================