package study201812_03;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class FileIO {

	public static void main(String[] args) throws IOException, URISyntaxException {
		// testFile();
		// delTestOutputFile();
		// createFile_toSrc();
		// deleteFile_fromSrc();
		// String fileNameStr = getFileNameFromFolder(".");//.代表当前selfstudy目录
		// System.out.println(fileNameStr);
		// String fileNameStr2 =
		// getFileNameFromFolder("selfstudy");//不能这样写,当前目录本身只能通过绝对路劲去找。
		// String fileNameStr3=
		// getFileNameFromFolder("src");//但是可以这样写，因为这是当前目录selfstudy下的目录，可通过相对路径找到。
		// System.out.println(fileNameStr3);
		// String filenameStr4 =
		// getFileNameFromFolderByFileFilter(".",".");//获取当前目录下文件名含.的文件名称
		// System.out.println(filenameStr4);
		//System.out.println(CalculateNFactorial(16));
		ArrayList<String> filenamelist = findFileInDirectory("src");
		for (String filename : filenamelist) {
			System.out.println(filename);
		}
	}

	// File,读取文件内容输出到另一个文件中
	public static void testFile() throws IOException, URISyntaxException {
		URL url = FileIO.class.getResource("testIOFile");// 获取文件url的方式---读取的是编译后的文件路径，在Bin目录下
		System.out.println("文件URL----" + url);
		System.out.println("文件URI----" + url.toURI());
		File f = new File(url.toURI());
		System.out.println("file name : " + f.getName());
		System.out.println("file AbsolutePath : " + f.getAbsolutePath());
		System.out.println("file Parent : " + f.getParent());
		System.out.println("---------start read file---------------");
		FileInputStream fi = new FileInputStream(f.getAbsolutePath());
		// 为了把文件放到Src下，把文件路劲中的bin替换为src
		String ipath = url.toString().substring(url.toString().indexOf("/") + 1);
		System.out.println("文件读取路劲: " + ipath);
		String opath = ipath.substring(0, ipath.lastIndexOf("/")).replaceAll("/bin/", "/src/");
		System.out.println("文件输出路径: " + opath + "/testIOfile_O");
		FileOutputStream fo = new FileOutputStream(opath + "/testIOfile_O");
		byte[] buffer = new byte[512]; // 一次取出的字节数大小,缓冲区大小
		int numberRead = 0;
		while ((numberRead = fi.read(buffer)) != -1) { // numberRead的目的在于防止最后一次读取的字节小于buffer长度，
			fo.write(buffer, 0, numberRead); // 否则会自动被填充0
		}
		fi.close();
		fo.close();
		System.out.println("------in this path check the testIOfile_O file----");
	}

	// 删除testOfile_O测试输出文件
	public static void delTestOutputFile() {
		URL url = FileIO.class.getResource("testIOFile");
		String ipath = url.toString().substring(url.toString().indexOf("/") + 1);
		System.out.println("读取文件的路劲: " + ipath);
		String opath = ipath.substring(0, ipath.lastIndexOf("/")).replaceAll("/bin/", "/src/");
		System.out.println("写入文件的路劲: " + opath);
		System.out.println("---删除文件 : " + opath + "/testIOFile_O");
		// 删除文件
		delFile(opath, "testIOFile_O");
		System.out.println("----testIOFile_O--文件已删除--到文件目录下去查验-----");
	}

	// 删除文件
	public static void delFile(String path, String filename) {
		File file = new File(path + "/" + filename);
		if (file.exists() && file.isFile())
			file.delete();
	}

	// 更简单的文件操作
	public static void createFile_toSrc() {
		// "."表示当前目录selfstudy,Java中用File.separator替代目录分隔符不论在linux系统还是在windows都要适用。
		// File f=new File("src"+File.separator+"TestCreateNewFile.txt");
		// File f=new File("./"+"src"+File.separator+"TestCreateNewFile.txt");
		// 以上两种写法是等效的。

		File f = new File("src" + File.separator + "TestCreateNewFile.txt");
		if (!f.exists()) {
			try {
				if (f.createNewFile()) {
					System.out.println("文件创建成功: " + f.getAbsolutePath());
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 删除新文件
	public static void deleteFile_fromSrc() {
		File f = new File("src" + File.separator + "TestCreateNewFile.txt");
		if (f.exists() && f.isFile()) {
			if (f.delete()) {
				System.out.println("文件已删除: " + f.getAbsolutePath());
			}
		}
	}

	// 获取目录下的所有文件名称(文件名以空格隔开)
	public static String getFileNameFromFolder(String dir) {
		File f = new File(dir);
		StringBuilder listFileName = new StringBuilder();
		if (f.isDirectory()) {
			File[] listf = f.listFiles();
			for (int i = 0; i < listf.length; i++) {
				listFileName.append(listf[i].getName() + " ");
			}
		}
		return listFileName.toString();
	}

	// 文件过滤器筛选目录下的文件---找不到返回空字符串
	public static String getFileNameFromFolderByFileFilter(String dir, String containsString) {
		File f = new File(dir);
		StringBuilder listFileName = new StringBuilder();
		if (f.isDirectory()) {
			File[] flist = f.listFiles(new FileFilter() {
				// 返回文件名称以.开头的文件
				@Override
				public boolean accept(File pathname) {
					return pathname.getName().contains(containsString);
				}
			});
			for (int i = 0; i < flist.length; i++) {
				listFileName.append(flist[i].getName() + " ");
			}
		}
		return listFileName.toString();
	}

	/**
	 * 递归查找目录下的全部文件
	 * 
	 * @param dir
	 *        是指定的目录或文件
	 * @author Administrator
	 * @return 返回所有文件名称的list集合(不含目录)
	 */
	public static ArrayList<String> findFileInDirectory(String dir) {
		File f = new File(dir);
		ArrayList<String> listfiles=new ArrayList<String>();
		if (f.isDirectory()) {
			File[] flist = f.listFiles();
  			for (File file : flist) {
				if(file.isFile()){
					listfiles.add(file.getName());
				}else{
					listfiles.addAll(findFileInDirectory(file.getAbsolutePath()));
				}
			}
		}else if(f.isFile()){
			listfiles.add(f.getName());
		}else{
			System.out.println("--文件或目录不存在，请输入正确的目录或文件--");
		}
		return listfiles;
	}

	/**
	 * 使用递归算法实现n!的计算
	 * 
	 * @param n
	 *        类型n表示要计算阶乘的数,n要大于1才有意义. 根据测试n的最大值为16.大于16计算结果超出int所能表示的范围.
	 * @return 返回int类型的计算结果,如果计算结果超过2147483647,则不能正确显示计算结果.
	 *         若返回负数或零则表示计算结果超出了int类型所能表示的范围.
	 */
	public static int CalculateNFactorial(int n) {
		if (n > 1) {
			return n * CalculateNFactorial(n - 1);
		} else {
			return 1;
		}

	}
}
