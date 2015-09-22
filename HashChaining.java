class Node {
    int data;
    Node next;
        
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public int getData() {
        return data;
    }

    /*public void geData() {
        System.out.println(data);
    }*/
}

class HashTable {
    Node[] hashTable;
    public HashTable() {
        hashTable = new Node[1000];
    }

    public Node push(Node head, int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }
    
    public int hash(int key){
        return key % 11;
    }

    public void display() {
        for(int i =0; i < 11 ; i++) {
            if(hashTable[i] != null)
            System.out.println(hashTable[i].data);
        }
    }

    public void insert(int data){
        int hash_key = this.hash(data);
        Node head = this.hashTable[hash_key];
        if(head == null){
            head = new Node(data);
            head.next = null;
        }
        else {
            head = push(head, data);  
        }
    }
}
public class HashChaining {
    public static void main(String[] args) {
        HashTable hashObj = new HashTable();
        // 96,  43,  72,  68,  63,  28
        hashObj.insert(96);
        hashObj.insert(43);
        hashObj.insert(72);
        hashObj.insert(68);
        hashObj.insert(63);
        hashObj.insert(28);

        hashObj.display();
    }
}    
