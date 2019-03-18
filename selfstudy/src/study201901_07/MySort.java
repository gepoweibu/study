package study201901_07;

import java.util.Calendar;
import java.util.Random;

public class MySort {

	public static void main(String[] args) {
		//addSeparatorPrintArray(bubbleSort(getArrayRandomInt()));
		//addSeparatorPrintArray(selectSort(getArrayRandomInt()));
		//addSeparatorPrintArray(insertSort(getArrayRandomInt()));
		//addSeparatorPrintArray(binaryInsertSort(getArrayRandomInt()));
	}

	public static void addSeparatorPrintArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			if (i == array.length - 1)
				System.out.println();
		}
	}

	public static int[] getArrayRandomInt() {
		int[] array = new int[20];
		Random random = new Random(Calendar.getInstance().getTimeInMillis());
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100) + 1;
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					i--;
					break;
				}
			}
		}
		return array;

	}

	/**
	 * 冒泡排序
	 * 
	 * @param arr 传入数组
	 * @return 返回排序后数组
	 */
	public static int[] bubbleSort(int[] arr) {
		// arr.length-1趟排序,外层循环控制循环躺数,每趟排序选出最值放到下标为i的位置
		for (int i = 0; i < arr.length - 1; i++) {
			// 内层循环控制每趟比较次数，并按条件交换数据，从下标为i+1的位置比较到数组末尾
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {// 交换数据
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				System.out.println("第：" + (i + 1) + "躺 第：" + (j - i) + "次排序---");
				addSeparatorPrintArray(arr);
			}
		}
		return arr;
	}

	/**
	 * 选择排序：从所有数据中选择最值(记录最值，选择完后交换数据)，放到下表为i的位置i=0，1，2...arr.length-2
	 * 
	 * @param arr 传入数组
	 * @return 返回排序数组
	 */
	public static int[] selectSort(int[] arr) {
		// 外层控制下标为i的数组位置
		for (int i = 0; i < arr.length - 1; i++) {
			int mIndex = i;// 记录最值下标
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[mIndex] > arr[j]) {
					mIndex = j;
				}
			}
			// 交换把最值放入arr[i]
			if (mIndex != i) {
				int temp = arr[i];
				arr[i] = arr[mIndex];
				arr[mIndex] = temp;
			}
			System.out.println("第"+(i+1)+"次选择排序：");
			addSeparatorPrintArray(arr);
		}
		return arr;
	}
	/**
	 * 直接插入排序：arr[i]为key值,剩余数据和key比较,大于key往后移动,
	 * 否则key值赋值给arr[j](arr[j]中的数据已保存在a[j+1])的位置。
	 * @param arr
	 * @return
	 */
	public static int[] insertSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			addSeparatorPrintArray(arr);
			int key=arr[i];//已arr[i]为k值(要插入的值)
			int j=i-1;//从i-1的位置向前搜索
			//比key值大的数据都往后移动,知道j=0或找打比key值小的数据(将key之插入该位置之后)
			while(j>-1&&arr[j]>key) {
				arr[j+1]=arr[j];//元素后移
				j--;//j被减1,所以下面的j+1其实就是j的值
			}
			arr[j+1]=key;//将key之插入arr[j]之后
		}
		return arr;
	}
	/**
	 * 二分插入排序
	 * @param arr
	 * @return
	 */
	public static int[] binaryInsertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
	        int key = arr[i];
	        int low = 0, high = i - 1;
	        int mid = -1;
	        while (low <= high) {            
	            mid = low + (high - low) / 2;            
	            if (arr[mid] > key) {               
	                high = mid - 1;            
	            } else { // 元素相同时，也插入在后面的位置                
	                low = mid + 1;            
	            }        
	        }        
	        for(int j = i - 1; j >= low; j--) {            
	            arr[j + 1] = arr[j];        
	        }        
	        arr[low] = key;
	        addSeparatorPrintArray(arr);
	        System.out.println();
	    }
		return arr;
	}
}
