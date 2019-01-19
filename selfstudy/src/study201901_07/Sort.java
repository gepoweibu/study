package study201901_07;
import java.util.Calendar;
import java.util.Random;

/**
 * Hello world!
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] array1 = getArrayRandomInt();
        int[] array2 = getArrayRandomInt();
        int[] array3 = getArrayRandomInt();
        int[] array4 = getArrayRandomInt();
        int[] array5 = getArrayRandomInt();
        int[] array6 = getArrayRandomInt();
        System.out.println("---bubbleSort---");
        addSeparatorPrintArray(array1);
        addSeparatorPrintArray(bubbleSort(array1));
        System.out.println("---selectSort---");
        addSeparatorPrintArray(array2);
        addSeparatorPrintArray(selectSort(array2));
        System.out.println("---insertSort---");
        addSeparatorPrintArray(array3);
        addSeparatorPrintArray(insertSort(array3));
        System.out.println("---quickSort---");
        addSeparatorPrintArray(array4);
        addSeparatorPrintArray(wrapQuickSort(array4));
        System.out.println("---shellSort---");
        addSeparatorPrintArray(array5);
        addSeparatorPrintArray(shellSort(array5));
        System.out.println("---heapSort---");
        addSeparatorPrintArray(array6);
        addSeparatorPrintArray(heapSort(array6));

    }

    public static void addSeparatorPrintArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (i == array.length - 1)
                System.out.println();
        }
    }

    public static int[] selectSort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    int temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }
        }
        return ints;
    }

    public static int[] insertSort(int[] array) {
        int current, preIndex;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            preIndex = i;
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] wrapQuickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] array, int low, int hight) {
        if (low >= hight)
            return;
        int i = low;
        int j = hight;
        int KeyValue = array[low];
        while (i < j) {
            while (i < j && array[j] > KeyValue) {
                j--;
            }
            while (i < j && array[i] <= KeyValue) {
                i++;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }
        array[low] = array[i];
        array[i] = KeyValue;
        quickSort(array, low, i - 1);
        quickSort(array, i + 1, hight);
    }

    public static int[] shellSort(int[] array) {
        int len = array.length;
        while (len != 0) {
            len = len / 2;
            for (int i = 0; i < len; i++) {
                for (int j = i + len; j < array.length; j += len) {
                    int k = j - len;
                    int temp = array[j];
                    while (k >= 0 && temp < array[k]) {
                        array[k + len] = array[k];
                        k -= len;
                    }
                    array[k + len] = temp;
                }
            }
        }
        return array;
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
    public static int[] heapSort(int[] array){
        for(int i=array.length/2-1;i>=0;i--){
            adjustHeap(array,i,array.length);
        }
        for(int j=array.length-1;j>0;j--){
            int temp=array[0];
            array[0] = array[j];
            array[j] = temp;
            adjustHeap(array,0,j);
        }
        return array;

    }
    public static void adjustHeap(int[] array,int i,int length){
        int temp = array[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && array[k]<array[k+1]){
                k++;
            }
            if(array[k] >temp){
                array[i] = array[k];
                i = k;
            }else{
                break;
            }
        }
        array[i] = temp;
    }
}
