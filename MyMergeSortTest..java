import java.util.*;
class MyMergeSort {
     
    Comparable[] array;
    Comparable[] tempMergArr;
    int length;
 
    public void sort(Comparable inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new Comparable[length];
        mergeSort(0, length - 1);
    }
    public void display() {
        for(int i =0; i< length-1;i++) {
            System.out.println(array[i]);
        }
    }
    private void mergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;

            mergeSort(lowerIndex, middle);
            
            mergeSort(middle + 1, higherIndex);
            
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i].compareTo(tempMergArr[j]) <= 0) {
                array[k] = tempMergArr[i];
                 System.out.println(array[k] + "array[if]");
                i++;
            } else {
                array[k] = tempMergArr[j];
                 System.out.println(array[k] + "array[else]");
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
             System.out.println(array[k] + "array[2]");
            k++;
            i++;
        }
    }
}

public class MyMergeSortTest {
    public static void main(String a[]){
        // String[] inputArr = {"45","23","11","89","77","98","4","28","65","43"};
        Integer[] inputArr = {45,23,-11,89,77,98,-4,28,65,43};
        MyMergeSort mms = new MyMergeSort();
        mms.sort(inputArr);
        mms.display();
/*        int[] as = {1,1,4,2,5,3};
         System.out.println(Arrays.toString(as));*/
        
    }
}   
