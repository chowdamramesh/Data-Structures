class Hashing< K,V> {
	K key;
	V value;
}
class MyHashtable<K,V> {
	Hashing<K,V>[] hashingObj;

	MyHashtable(int size) {
		hashingObj = new Hashing[size];
		for (int i = 0;i < size; i++ ) {
			hashingObj[i] = new Hashing();
		}
	}
	
	public void insertInHashTable(K key, V value) {
		int hash = hashCodeGen((String)key);
		hashingObj[hash].value = value;
	}
	public void insertInHashTable(int key, V value) {
		hashingObj[key].value = value;
	}

	public V getValue(int key) {
		V temp = hashingObj[key].value;
		return temp;
	}

	public V getValue(K key) {
		int hash = hashCodeGen((String)key);
		V temp = hashingObj[hash].value;
//		System.out.println(temp);
		return temp;
	}
	
	public int hashCodeGen(String element) {
        int hash = 1;
        for(int i = 0; i < element.length();i++) {
            hash += element.charAt(i) + (3*i);
        }    
            return hash;
    }	
}

public class MyHashTableTest {
	public static void main(String[] args) {
		MyHashtable<String,String> myHashtableObj = new MyHashtable<String,String>(12301);

		myHashtableObj.insertInHashTable("0" ,"Ramesh");
		myHashtableObj.insertInHashTable("1" ,"Chandra");
		myHashtableObj.insertInHashTable("2" ,"Rammi");
		System.out.println(myHashtableObj.getValue("2"));
		
	}	
}
