package study201812_03;

import java.io.File;

public class DeleteDirectory {

	public static void main(String[] args) {
	}

	/**
	 * 递归删除目录
	 * 
	 * @param dir
	 *            给定的目录
	 */
	public static void deleteDir(File dir) {
		if (dir.isDirectory()) {
			File[] dirs = dir.listFiles();
			for (File file : dirs) {
				deleteDir(file);
			}
		}
		dir.delete();
	}

}
