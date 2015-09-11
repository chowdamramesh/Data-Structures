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

	public void heapSort() {
		int index = n;
		for(int i = 1; i <= index; i++) {
			System.out.print(deleteMin() + " ");
		}
	}

}

public class BinaryHeapSort {
	public static void main(String[] args) {

		BinaryHeap binaryObj = new BinaryHeap(10);

		binaryObj.insert(4);
		binaryObj.insert(5);
		binaryObj.insert(8);
		binaryObj.insert(9);
		binaryObj.insert(9);
		binaryObj.insert(4);
		binaryObj.insert(5);
		binaryObj.insert(8);
		binaryObj.insert(9);
		
		binaryObj.heapSort();
	}	
}
