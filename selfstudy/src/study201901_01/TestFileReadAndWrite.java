package study201901_01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.filechooser.FileSystemView;

public class TestFileReadAndWrite {
	/**
	 * 测试文件的读写方法
	 * 
	 * @author Administrator
	 * @param args
	 * @since JDK 1.8
	 * 
	 */
	public static void main(String[] args) {
		// testFileRW();
		// lineSeparator();
		testRWImage();
	}

	/**
	 * 文件输入输出字符流:测试FileReader和FileWriter.
	 */
	public static void testFileRW() {
		try {
			File f = new File("src" + File.separator + "study201812_03" + File.separator + "testIOFile");
			// File("src"+File.separator+"study201812_03"+File.separator+"testIOFile");
			FileReader fr = new FileReader(f);
			// 获取文件编码
			System.out.println("文件编码: " + fr.getEncoding());
			// Read a single character 读取单个字符
			System.out.println("读取的第一个字符:" + (char) fr.read());// --------read()一次指正就往下加一,所以下面是从第二个字符读取的。
			char[] cbuf = new char[21];// 为留的读取设置缓冲区
			System.out.println("读取的字符个数: " + fr.read(cbuf));
			for (int i = 0; i < cbuf.length; i++) {
				System.out.println("缓冲区第 " + (i + 1) + " 个字符: " + cbuf[i]);
			}
			System.out.println("文件长度: " + f.length() + " 字节");
			System.out.println("-------下面的内容是紧接着上面的内容读取的100个字节数据------");
			// 把文件内容原样输出到控制台
			char[] cbuf2 = new char[100];
			fr.read(cbuf2);// 读取100个字符数据(这回接着上面的50个字符后继续读取文件内容,而不是重头开始读取)
			for (int i = 0; i < cbuf2.length; i++) {
				System.out.print(cbuf2[i]);
			}
			System.out.println();// 文件内容输出完毕,换行
			FileReader fr2 = new FileReader(f);// ---------重新读取文件----------
			System.out.println("------------******重置流读取文件*******--------------");
			char[] cbuf3 = new char[250];
			fr2.read(cbuf3);//
			for (int i = 0; i < cbuf3.length; i++) {
				System.out.print(cbuf3[i]);
			}
			System.out.println();// 文件内容输出完毕,换行
			// -----------最常用的文本文件内容读取方法--------------
			FileReader fread = new FileReader(f);// ---------重新读取文件----------
			FileWriter fwrite = new FileWriter(
					"src" + File.separator + "study201901_01" + File.separator + "WriterFileFromtestFileRW.txt");
			System.out.println("------------******最常用的文件读取方法*******--------------");
			char[] cbuffer = new char[50];// 每次读取的字符数，用字符数组保存。
			int readCharNumber = 0; //
			while ((readCharNumber = fread.read(cbuffer)) != -1) { // cbuffer为每次读取的字符数,read()方法返回-1说明数据已读完。
				for (int i = 0; i < readCharNumber; i++) {// 这行的readCharNumber不能用cbuffer.length()替换，否则最后一次很可能会读取垃圾数据
					System.out.print(cbuffer[i]);
				}
				fwrite.write(cbuffer, 0, readCharNumber);
			}
			fr.close();// 关闭fr流
			fr2.close();// 关闭fr2流
			fread.close();
			fwrite.close();
			// 没有缓冲区的数据，在流关闭后才会输出。
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取当前系统的换行符
	 */
	public static void lineSeparator() {
		// 注意在将流写入文件时，换行应根据操作系统的不同来决定。
		// 在程序我们应尽量使用System.getProperty("line.separator")来获取当前系统的换
		// 行符，而不是写/r/n或/n。
		// 这样写程序不够灵活
		// 当我们在java控制台输出的时候，/r和/n都能达到换行的效果。
		if (System.getProperty("line.separator").equals("\r\n")) {
			System.out.println("\\r\\n is for windows");
		} else if (System.getProperty("line.separator").equals("\r")) {
			System.out.println("\\r is for Mac");
		} else if (System.getProperty("line.separator").equals("\n")) {
			System.out.println("\\n is for Unix/Linux");
		}
	}

	/**
	 * 把src/study201901_01/InputStream.png输出到桌面
	 */
	public static void testRWImage() {
		File f = new File("src" + File.separator + "study201901_01" + File.separator + "InputStream.png");
		// 获取用户桌面路径
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File homeDir = fsv.getHomeDirectory();
		File hf = new File(homeDir.getAbsolutePath() + File.separator + "InputStream.png");
		if (!hf.exists()) {
			try {
				hf.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("用户桌面路径 :" + homeDir);
		try {
			InputStream in = new FileInputStream(f);
			OutputStream out = new FileOutputStream(hf);
			BufferedInputStream bis = new BufferedInputStream(in, 1024);// 使用缓冲1024字节,也就是内存有1024字节缓冲区让cpu从硬盘读取数据
			BufferedOutputStream bos = new BufferedOutputStream(out);
			byte[] readbuffer = new byte[1024];// 创建一个字节数组存放从上面1024字节的内存中一次取出的数据。两次缓冲的性质不一样。一个是从硬盘读到内存的缓冲
			int readbytenum = 0;// 保存每次实际读取的字节数
			while ((readbytenum = bis.read(readbuffer)) != -1) {
				out.write(readbuffer, 0, readbytenum);
			} // 一个是从内存写到硬盘或输出到屏幕的缓冲。
			bis.close();
			bos.close();
			System.out.println("-----请到桌面查看InputStream.png图片文件-----");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("删除当前在桌面生成的InputStream.png图片文件？");
			System.out.println("按y键盘删除       任意键取消:");
			char chose;
			try {
				chose = (char) System.in.read();//read()读取一个字节的数据,键盘上的字符长度都小于一个字节所以可以强制转换为字符。
				                                //另一种解决办法，用Scanner类读取用户输入的字符串用charAt(0)截取第一个字符。
				if ('y' == chose || 'Y' == chose) {
					if (hf.exists()) {
						hf.delete();
						System.out.println("---删除完成---");
					}
				}else{
					System.out.println("--删除取消--");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
