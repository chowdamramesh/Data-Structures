import java.util.*;
import java.io.*;
class Hashing {
static final Integer ONE = new Integer(1);
	void addWord(Map map,String word) {
	
    Object obj = map.get(word);
    if (obj == null) {
      map.put(word, ONE);
    } else {
      int i = ((Integer) obj).intValue() + 1;
      map.put(word, new Integer(i));
    }
  }
}
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

	public List<Integer> heapSort() {
		int index = n;
		List<Integer> ar = new ArrayList<Integer>();

		for(int i = 1; i <= index; i++) {
			ar.add(deleteMin());
			//System.out.print(deleteMin() + " ");
		}
		return ar;
		//System.out.println(ar);
	}

}
public class HashMain {
	public static void main(String[] args) {
		String data = "";
		Hashtable<String,Integer> hm = new Hashtable<String,Integer>();
		Hashing temp = new Hashing();

		try	{
			BufferedReader br = new BufferedReader(new FileReader("simple.txt"));
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				data += currentLine;
				//System.out.println(currentLine);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		//System.out.println(data);
		String[] divide = data.split(" ");
		for (int i = 0;i < divide.length;i++) {
			temp.addWord(hm,divide[i]);
		}
		BinaryHeap binaryObj = new BinaryHeap(100);

		Set<String> keys = hm.keySet();
        for(String key: keys){
        	binaryObj.insert(hm.get(key));
            //System.out.println(key+"::"+hm.get(key));
        }
        List<Integer> te = new ArrayList<Integer>();
        te = binaryObj.heapSort();
        // for(int j =te.size()-1; j>0;j--) {
        // 	System.out.println(te.get(j));
        // }
        //Set<String> keys = hm.keySet();
        
       	for(int j =te.size()-1 ; j >0 ;j--) {
       		for(String key: keys){
        		if(te.get(j).equals(hm.get(key))) {
                	System.out.println("freq :: "+hm.get(key));
                	System.out.println("word ::"+key);
                	break;
            	}
        	//System.out.println(te.get(j));
        	}
        }
        // System.out.println(te);
		//System.out.println(hm);
	}	
}
