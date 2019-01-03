网络编程练习包:
1.Socket和SeverSocket类的使用练习。
SayHelloClient和SayHelloServer必须分开运行，不然会报端口被占用的错误。
解决办法：开两个命令行窗口，一个运行客户端，一个运行服务端。
从一个cmd窗口打开另一个窗口的命令：start cmd.
------------------------------------------------------------
JDK环境变量设置： 用户环境变量只对当前用户起作用，系统环境变量对所有用户起作用。
系统变量：JAVA_HOME==C:\Program Files (x86)\Java\jdk1.8.0_191
        CLASSPATH==.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;//.表示当前目录
Path添加：%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin
--javac Test.java----编译报错--编码GBK的不可映射字符---------------------------
解决办法：
 javac -encoding utf-8 Test.java