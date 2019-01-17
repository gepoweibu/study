mybatis的mapper文件:一个pojo类只需实现其中的一种即可。
1.对于简单的sql映射可以用dao接口创建（用接口中的方法绑定sql并传递查询参数）
2.对于复杂的sql建议使用xml配置mapper。

mybatis的xml映射文件和接口绑定注意：
	1.xml的名称空间是接口的相对路径：eg：namespace="com.weibu.dao.IUser"
	2.xml中的id属性对应接口中懂得方法名(一模一样才行)，其余参数返回值类型要一致。
mybatis中文乱码：jdbc配置时指定编码
	1.eg：<property name="url" value="jdbc:mysql://localhost:3306/ssm?
		 useUnicode=true&amp;characterEncoding=utf-8" />
	2.xml文件中要用amp;转义&符号，一般的properties文件中不需要。