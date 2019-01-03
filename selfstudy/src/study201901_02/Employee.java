package study201901_02;

import java.io.Serializable;

/**
 * 2019年1月3日18:44:15
 * @author Administrator
 *
 */
public class Employee implements Serializable{

	private static final long serialVersionUID = -8311612882465714288L;
	public String name;
	public String address;
	public transient int SSN;//被声明为短暂的属性，不能被序列化
	public int number;
	public void checkMail(){
		System.out.println("Mailing a check : "+name+"  "+address);
	}
}
