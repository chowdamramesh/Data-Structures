class InsertionSorting<E extends Comparable<E>> {
	
	public void insertOrder(E[] array , int num ) {
		int hole = 0;
		for (int i = 0; i < num; i++ ) {
			E value = array[i];
			hole = i;
			while (hole > 0 && (array[hole-1].compareTo(value) > 0) ) {
				array[hole] = array[hole-1];
				hole = hole-1;
			}
			array[hole] = value;
 		}

		for (int i = 0; i < array.length; i++) {
         	System.out.print(array[i] + " ");
      	}
      	System.out.println();
	}
}
public class InsertionSortTest {
	public static void main(String[] args) {
		InsertionSorting<Integer> sSObj = new InsertionSorting<Integer>();

		Integer[] arr = {10,9,8,5,4,7,2,3,6,1} ;
		// String[] str = {"ramu","rammi","ramesh"};
		sSObj.insertOrder(arr , arr.length);
		// sSSObj.sortOrder(str , str.length);
	}
}
