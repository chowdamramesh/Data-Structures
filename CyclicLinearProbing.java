import java.util.*;
class Hash {

    String[] hObj;

    Hash() {
       hObj = new String[12];
    }

    public int hash(String input) {
    	String ramm = input;
    	String one = "";
        String two = "";
        for(int i = 0; i < ramm.length();i++) {
            if (i % 2 == 0) {
                one += ramm.charAt(i);
            } else {
                two += ramm.charAt(i);
            }
        }
       /* System.out.println(one);
        System.out.println(two);*/
        // System.out.println(hashfun(one));
        // System.out.println(hashfun(two));
        int address = (hashfun(one)+hashfun(two));
        int key = address % 12;
       /* System.out.println(address);
        System.out.println(key);*/
        return key;
    }

    public int hashfun(String element) {
    	int hash = 0;
    	for(int i = 0; i < element.length();i++) {
		    hash += element.charAt(i);
		}
        // System.out.println(hash);
        hash = hash % 12;
		return hash;
	}

	public boolean isVacant(int key) {
        if(hObj[key] == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insert(String value) {
        Integer key = hash(value);
       // int key = hash(element);
        if (!isVacant(key)) {
            Integer ind = key;
            Integer temp = 0;
            for (Integer i = ind % 12; temp < 12; ind++ ) {
                if(isVacant(key)) {
                   break;
                }
                i = ind % 12;
                key = i;
                temp++;
            } 
        }
        hObj[key] = value;
        //System.out.println(key);
    }
    public void remove(String value) {
        Integer key = hash(value);
        if (!hObj[key].equals(value)) {
            Integer ind = key;
            Integer temp = 0;
            for (Integer i = ind % 12; temp < 12; ind++ ) {
                if(hObj[key] == value) {
                hObj[key] = null;
                   break;
                }
                i = ind % 12;
                key = i;
                temp++;
            } 
        } else {
            hObj[key] = null;
        }
        rehash(key );
        // display();
        // System.out.println("after remove");
       // moveBack(key);
    }
    public void rehash(Integer key) {
        // System.out.println(key+"sdasffas");
        Integer temp = 0;
        for (Integer i = key ; temp < 10; key++) {
                if(hObj[i] != null) {
                    Integer hash = hash(hObj[i]);
                    if(hObj[hash] == null) {
                        hObj[hash] = hObj[i];
                        //System.out.println(hObj[hash]);
                        hObj[i] = null;
                        // key++;
                    }    
                }
            i = key % 10;
                    // System.out.println(i+"/*****");
            temp ++;
        }
    }
    public void moveBack(Integer key) {
        Integer temp = 0;
        for (Integer i = key ; temp < 12; key++) {

                if(hObj[i] != null) {
            /*        Integer hash = hash(hObj[i]);
            System.out.println(hash + "hash");
            */      // System.out.println(hObj[i]+"-------------");
                if (hash(hObj[i]) == i ) {
                    int flag = 0;
                } else {
                    insert(hObj[i]);
                    hObj[i] = null; }
                }
            i = key % 12;
                    // System.out.println(i+"/*****");
            temp ++;
        }
    }

    public void display() {
    	String in = "";
        for(Integer i = 0; i < 11;i++) {
        	in += hObj[i] + ",";
            //System.out.println(hObj[i]+"    "+i);
        }
        in += hObj[11];
        System.out.println(in);
      //  System.out.println("--------");
    }
}

public class CyclicLinearProbing {
	public static void main(String[] args) {
		Hash hashObj = new Hash();
	//hai,hello,how,are,hello,how,are,how    //the set of elements to be inserted
	//hello,how                             //the set of elements to be deleted


		Scanner sc = new Scanner(System.in);
		String insert = sc.nextLine();

		String delete = sc.nextLine();

		String[] one = insert.split(",");
		String[] two = delete.split(",");
		
		for (int i = 0;i < one.length;i++)  {
			// System.out.println(one[i]);
			hashObj.insert(one[i]);
		}
		hashObj.display();
		for (int i = 0;i < two.length;i++)  {
			// System.out.println(two[i]);
			hashObj.remove(two[i]);
			hashObj.display();
		}

        /*hashObj.insert("hai");
        hashObj.insert("hello");
        hashObj.insert("how");
        hashObj.insert("are");
        hashObj.insert("hello");
        hashObj.insert("how");
        hashObj.insert("are");
        hashObj.insert("how");

        hashObj.display();
		System.out.println("---------------------------------");
        hashObj.remove("hello");
		hashObj.display();
		System.out.println("-------------/-/-///--------------------");
		hashObj.remove("how");
		hashObj.display();*/

	}
	
}
