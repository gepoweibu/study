package study201901_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class InputStreamAndOutputStream {

	public static void main(String[] args) {
		//testISAndOS();// 二进制读写输出到控制台存在乱码
		testISRAndOSW();
	}

	/**
	 * <p>
	 * 测试InputStream和OutputStream的使用 <br/>
	 * <br/>
	 * 上面的程序首先创建文件test.txt，并把给定的数字以二进制形式写进该文件， <br/>
	 * <br/>
	 * 同时输出到控制台上。 以上代码由于是二进制写入，可能存在乱码。
	 */
	public static void testISAndOS() {
		try {
			byte bWrite[] = { 11, 21, 3, 40, 5, 65, 78, 84 };
			OutputStream os = new FileOutputStream(
					"src" + File.separator + "study201901_01" + File.separator + "testISAndOS.txt");
			for (int x = 0; x < bWrite.length; x++) {
				os.write(bWrite[x]); // writes the bytes
			}
			os.close();
			InputStream is = new FileInputStream(
					"src" + File.separator + "study201901_01" + File.separator + "testISAndOS.txt");
			int size = is.available();

			for (int i = 0; i < size; i++) {// 二进制写入以系统默认编码读取，会存在乱码
				System.out.print((char) is.read() + "  ");
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * 使用 InputStreamReader(fi,encoding)和OutputStreamWriter(fo,encoding) <br/>
	 * <br/>
	 * 指定读写数据流的编码，即可解决乱码问题。
	 */
	public static void testISRAndOSW() {
		try {
			//new FileOutputStream(file)--------文件不存在会自动创建
			File f = new File("src" + File.separator + "study201901_01" + File.separator + "testISAndOS.txt");
			FileOutputStream fos = new FileOutputStream(f);
			//指定写入的数据流编码为utf-8
			// 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
			OutputStreamWriter osw= new OutputStreamWriter(fos, "utf-8");
			osw.write("瞧，她们又在"+System.lineSeparator()+"蔚蓝的天空里飘荡，"+System.lineSeparator());
			osw.append("仿佛是被遗忘了的"+System.lineSeparator()+"美妙的歌调一样！"+System.lineSeparator());
			//参数类型CharSequence为字符序列，底层转化为字符串，所以可直接输入字符串。
			osw.append("只有在风尘之中"+System.lineSeparator()+"跋涉过长途的旅途，"+System.lineSeparator());
			osw.append("懂得漂泊者的甘苦的人"+System.lineSeparator()+"才能了解她们。"+System.lineSeparator());
			osw.append("我爱那白色的浮云"+System.lineSeparator()+"我爱太阳，风和海"+System.lineSeparator());
			osw.append("因为他们是无家可归者的姊妹和使者。"+System.lineSeparator());
			osw.close();
			System.out.println("数据写入完成，文件路径: ");
			System.out.println(f.getAbsolutePath());
			System.out.println("-----------读取上面的文件数据输出到控制台--------------");
			FileInputStream fis = new FileInputStream(f);
			//以utf-8编码格式读取文件数据流，和写入的编码不同会出现乱码，可以换其他编码试试
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			char[] cbuf=new char[1024];//读取字符缓存数组
			int readlen=0;//记录每次读取字符个数
			while((readlen=isr.read(cbuf))!=-1){
				for (int i = 0; i < readlen; i++) {
					System.out.print(cbuf[i]);
				}
			}
			isr.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
