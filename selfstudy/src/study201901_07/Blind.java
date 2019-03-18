package study201901_07;

import java.util.ArrayList;
import java.util.List;

public class Blind {

	public static void main(String[] args) {
//		int[] arr = binaryInsertSort(new int[] { 8, 9, 5, 2, 3, 4 });
//		for (int i : arr) {
//			System.out.print(i + " ");
//		}
		List<Integer> list = getPrimeNumber2(25);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
	}

	public static int[] binaryInsertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int low = 0, hight = i - 1;
			int mid = -1, key = arr[i];
			while (low <= hight) {
				mid = low + (hight - low) / 2;
				if (arr[mid] > key) {
					hight = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			for (int j = i - 1; j >= low; j--) {
				arr[j + 1] = arr[j];
			}
			arr[low] = key;
		}
		return arr;
	}

	public static List<Integer> getPrimeNumber(int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= num; i++) {
			if (i % 2 != 0) {
				list.add(i);
			}
		}
		return list;
	}

	public static List<Integer> getPrimeNumber2(int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (num < 0) {
			return null;
		}
		if (num == 1) {
			list.add(1);
			return list;
		}
		if (num == 2) {
			list.add(1);
			list.add(2);
			return list;
		}
		if (num > 2) {
			list.add(1);
			for (int i = 2; i <= num; i++) {
				boolean flag = true;
				for (int j = 2; j <= i - 1; j++) {
					if (i % j == 0) {
						flag = false;
					}
				}
				if (flag) {
					list.add(i);
				}
			}
			return list;
		}
		return null;
	}
}
