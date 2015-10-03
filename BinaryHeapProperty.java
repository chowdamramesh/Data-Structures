import java.util.*;
class BinaryHeap {
	int[] hArray;
	int sizeOfArray;
	int n;

	BinaryHeap(int size) {
		sizeOfArray = size;
		hArray = new int[size];
		n = 0;
	}

	public void insert(int element) {
		if(n < sizeOfArray) {
			n++;
			hArray[n] = element;
			shiftUp(n);
		}
		
	}

	public void shiftUp (int i) {
		if(i == 1 || hArray[i/2] <= hArray[i]) {
			return;
		}
		//swap(hArray[i],hArray[(i/2)]);
		swap(i,(i/2));
		shiftUp((i/2));
	}

	public void swap(int x ,int y) {
		int dummy = 0;
		dummy = hArray[x];
		hArray[x] = hArray[y];
		hArray[y] = dummy;
	}

	public int deleteMin() {
		int result = 0;
		if(n > 0) {
			result = hArray[1];
			hArray[1] = hArray[n];
			n--;
			shiftDown(1);
		}
		return result;
	}

	public void shiftDown(int i) {
		int m;
		if((2*i) <= n) {
			if( ((2 * i) + 1) > n || hArray[2*i] <= hArray[(2*i) + 1]) {
				m = (2*i);
			}
			else {
				m = ((2*i) + 1);
			}

			if(hArray[i] > hArray[m]) {
				swap(i,m);
			}
			shiftDown(m);
		}
	}

	public void display() {
		for (int i =0; i <= n; i++)
		if (hArray[i] != 0)
		System.out.println(hArray[i]);
	}

	List<Integer> list2 = new ArrayList<Integer>();
	public List<Integer> heapSort() {
		int index = n;
		for(int i = 1; i <= index; i++) {
			// System.out.print(deleteMin() + " ");
			list2.add(deleteMin());
		}
		return list2;
	}

}

public class BinaryHeapProperty {
	public static void main(String[] args) {

		BinaryHeap binaryObj = new BinaryHeap(25);
		Scanner sc = new Scanner(System.in);
// 		System.out.println("size");
		int num = sc.nextInt();
// 		System.out.println("elements");
		sc.nextLine();
		String insert = sc.nextLine();
		String[] divide = insert.split(",");
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		for (int j =0; j < num; j++ ) {
			// System.out.println(divide[j]);
			binaryObj.insert(Integer.parseInt(divide[j]));
			list1.add(Integer.parseInt(divide[j]));
		}
		list2 = binaryObj.heapSort();
		if (compareList(list1,list2)) {
			System.out.println("True");
		} else {
			for (int i =0; i < list1.size(); i++) {
				binaryObj.insert(list1.get(i));
			}
			binaryObj.display();
		}
		
	}	
	public static boolean compareList(List ls1,List ls2){
        return ls1.toString().contentEquals(ls2.toString())?true:false;
    }
}
