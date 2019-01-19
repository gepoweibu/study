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
mysql 启动服务1067错误解决办法：
	删除my.ini文件,运行bin目录下的MysqlInstanceConfig.exe生成全新的配置文件
	字符集：
	- character_set_server：默认的内部操作字符集
	– character_set_client：客户端来源数据使用的字符集
	– character_set_connection：连接层字符集
	– character_set_results：查询结果字符集
	– character_set_database：当前选中数据库的默认字符集
	– character_set_system：系统元数据(字段名等)字符集
ini文件设置默认字符集：character_set_server=utf8;不是utf-8(5.1.17版本)设置错误重启会报1067错误。

查看字符集编码：show variables like '%character%';
set character_set_results=gb2312;设置临时字符集,重启mysql后会恢复为配置文件中的默认值。