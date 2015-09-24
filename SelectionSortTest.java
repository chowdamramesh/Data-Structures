class SelectionSorting<E extends Comparable<E>> {
	
	public void sortOrder(E[] array , int num ) {
		int min = 0 ;
		for (int i = 0; i < num-2; i++ ) {
			min = i;
			for (int j = i+1; j < num; j++) {
				if (array[j].compareTo(array [min]) < 0) {
					min = j ;
				}
			}
				E temp = array[i];
				array[i] = array[min];
				array[min] = temp;
		}
		for (int i = 0; i < array.length; i++) {
         	System.out.print(array[i] + " ");
      	}
      	System.out.println();
	}
}
public class SelectionSortTest {
	public static void main(String[] args) {
		SelectionSorting<Integer> sSObj = new SelectionSorting<Integer>();
		SelectionSorting<String> sSSObj = new SelectionSorting<String>();

		Integer[] arr = {10,9,8,5,4,7,2,3,6,1} ;
		String[] str = {"ramu","rammi","ramesh"};
		sSObj.sortOrder(arr , arr.length);
		sSSObj.sortOrder(str , str.length);
	}
}
