package study201901_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 一个类要序列化必须实现序列化接口0
 * @author Administrator
 * transient 表示短暂的,在可序列化的类中某个属性不想被序列化，用它声明。
 */
public class TestSerializable {

	public static void main(String[] args) {
		testSerializable();
		testDeserialize();
	}
	/**
	 * 序列化employee对象数据到指定文件中
	 */
	public static void testSerializable(){
		Employee e = new Employee();
		e.address="四川省凉山州那地方";
		e.name="小明or小红or小花";
		e.SSN=111222333;
		e.number=666;
		try{
			File f=new File("src"+File.separator+"study201901_02"+File.separator+"employee.ser");
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(e);//写入对象数据
			oos.close();
			System.out.println("保存Employee对象序列化数据的文件:");
			System.out.println(f.getAbsolutePath());
		}catch(IOException i){
			i.printStackTrace();
		}
	}
	/**
	 * 从序列化Employee文件中读取该对象的数据
	 */
	public static void testDeserialize(){
		Employee e=null;
		try{
			File f=new File("src"+File.separator+"study201901_02"+File.separator+"employee.ser");
			FileInputStream fis=new FileInputStream(f);
			ObjectInputStream ois=new ObjectInputStream(fis);
			e=(Employee)ois.readObject();
			ois.close();
		}catch(IOException i){
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException e1) {
			System.out.println("Employee class not found");
			e1.printStackTrace();
			return;
		}
		System.out.println("反序列化Employee对象的数据: ");
		System.out.println("name: "+e.name);
		System.out.println("address: "+e.address);
		System.out.println("SSN: "+e.SSN);
		System.out.println("number: "+e.number);
	}
}
