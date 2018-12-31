package study201812_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

public class FileIO {

	public static void main(String[] args) throws IOException, URISyntaxException {
		testFile();
	}
	//File
	public static void testFile() throws IOException, URISyntaxException{
		URL url = FileIO.class.getResource("testIOFile");//获取文件url的方式---读取的是编译后的文件路径，在Bin目录下
		System.out.println("文件URL----"+url);
		System.out.println("文件URI----"+url.toURI());
		File f=new File(url.toURI());
		System.out.println("file name : "+f.getName());
		System.out.println("file AbsolutePath : "+f.getAbsolutePath());
		System.out.println("file Parent : "+f.getParent());
		System.out.println("---------start read file---------------");
		FileInputStream fi=new FileInputStream(f.getAbsolutePath());
		//为了把文件放到Src下，把文件路劲中的bin替换为src
		String opath = f.getParent().replaceAll("bin", "src");
		System.out.println("output path : "+opath);
		FileOutputStream fo = new FileOutputStream(f.getParent().replaceAll("bin", "src")+"/testIOfile_O");
		byte[] buffer=new byte[512];   //一次取出的字节数大小,缓冲区大小  
	    int numberRead=0;  
	    while ((numberRead=fi.read(buffer))!=-1) {  //numberRead的目的在于防止最后一次读取的字节小于buffer长度，  
	    	fo.write(buffer, 0, numberRead);       //否则会自动被填充0  
	    }
	    fi.close();
	    fo.close();
	    System.out.println("------in this path check the testIOfile_O file----");
	}

}
