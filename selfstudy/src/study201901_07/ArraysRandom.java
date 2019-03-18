package study201901_07;

import java.util.Random;

public class ArraysRandom {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		arr=getRandomSortArray(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
		
	}
	public static int[] getRandomSortArray(int[] arr) {
		int r= new Random().nextInt(arr.length);
		for (int i = 0; i < arr.length; i++) {
			int temp=arr[i];
			arr[i]=arr[r];
			arr[r]=temp;
		}
		return arr;
	}
}
