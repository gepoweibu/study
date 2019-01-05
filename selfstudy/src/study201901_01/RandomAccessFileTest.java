package study201901_01;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile(
				"src" + File.separator + "study201901_01" + File.separator + "RandomAccessFileTest.txt", "r");
		RandomAccessFile copy = new RandomAccessFile(
				"src" + File.separator + "study201901_01" + File.separator + "RandomAccessFileTest_Copy.txt", "rw");
		int b = 0;
		while ((b = src.read()) != -1) {
			copy.write(b);
		}
		copy.close();
		src.close();
		// for (int i = 0; i < 10; i++) {
		// System.out.println(Integer.toBinaryString(i));
		// System.out.println(Integer.toBinaryString(-i));
		// }
	}

}
