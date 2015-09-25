class MyLinkedList<E> {
    
    @SuppressWarnings("rawtypes")
    private Node head;
    private int listCount;
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public MyLinkedList() {
        head = new Node(null);
        listCount = 0;
    }

    public Node getHead() {
        return head;
    }
    public void addAtIndex(E data, int index) {
        Node temp = new Node(data);
        Node current = head;
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        listCount++;
    }
    
    public String toString() {
        String output = "";
        if(head == null) {
            output = "List is Empty";
        } else {
            Node current = head.getNext();
            while (current != null) {
                output += current.getData() + "->" ;
                current = current.getNext();
            }
        }
        return output;
    }
    public void pushFront(E element) {
        addAtIndex(element,0);
    }
}

class Hash {

    MyLinkedList<Integer>[] linkedObj = new MyLinkedList[11];

    Hash() {
        for (int i =0; i < 11 ;i++ ) {
            linkedObj[i] = new MyLinkedList() ;
        }
    }

    public int hash(int value){
        return value % 11;
    }
    
    public void insert(int value) {
        int key = hash(value);
        linkedObj[key].pushFront(value);
        //System.out.println(key);
    }
    
    public void find(int value) {
        int find = hash(value);
        System.out.println(linkedObj[find]);
        
    }
    
    public void display() {
        for(int i =0; i < 11;i++) {
            System.out.println(linkedObj[i] +"\t\t"+i);
        }
    }
}

class Node<E> {
    
    Node next;
    E data;
    @SuppressWarnings("unchecked")
    public Node() {
        next = null;
        data = null;
    }
    public Node(E dataValue) {
        next = null;
        data = dataValue;
    }

 
    public Node(E dataValue, Node nextValue) {
        next = nextValue;
        data = dataValue;
    }

    public E getData() {
        return data;
    }

    public void setData(E dataValue) {
        data = dataValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        next = nextValue;
    }


}
public class MyHashChain {
    public static void main(String[] args) {
        Hash hashObj = new Hash();
        // 96,  43,  72,  68,  63,  28
        
        hashObj.insert(96);
        hashObj.insert(43);
        hashObj.insert(72);
        hashObj.insert(68);
        hashObj.insert(63);
        hashObj.insert(28);

        hashObj.display();
        //hashObj.find(43);
        // hashObj.find(28);
    }
}
