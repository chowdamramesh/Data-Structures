import java.util.Scanner;
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

	/*public void heapify(BinaryHeap h , int hArray[] , int n) {
		if(h == null) {
			return;
		}
		while (n > this.)
	}*/

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
	public void print() {
		for(int i = 1; i <= n; i++) {
			System.out.print(hArray[i]+ " ");
		}
		System.out.println();	
	}

	public void modify(int index , int element) {
		if(n < sizeOfArray) {
			hArray[index] = element;
			shiftDown(index);
			shiftUp(index);
		}
	}
}

public class BinaryHeapTest {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		BinaryHeap binaryObj = new BinaryHeap(20);
		String input;
		String operationToPerform;
		String read1;
		String read2;
		input = kb.nextLine();

		String[] divide = input.split(",");

		for(int i = 0; i < divide.length;i++) {
			//System.out.println(divide[i]);
			while(!(divide[i]).equals("end")) {
				String[] temp = divide[i].split(" ");
				for(int j = 0; j < temp.length; j++) {
					//System.out.println(temp[j]);
					switch(temp[0]) {
					  	case "i": 
							binaryObj.insert(Integer.parseInt(temp[1]));
							binaryObj.print();
							break;
						case "d": 
							binaryObj.deleteMin();
							binaryObj.print();
							break;
						case "mo": 
							binaryObj.modify(Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
							binaryObj.print();
							break;
						default:
							 //System.out.println("Invalid input");
							break;
					}
					break;
				}

				break;
			}

		}
		// binaryObj.print();
	}	
}
