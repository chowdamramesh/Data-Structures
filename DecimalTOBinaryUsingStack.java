import java.util.*;
public class DecimalTOBinaryUsingStack {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		//System.out.println("enter the number");
    	//int number = kb.nextInt();
    	String input = kb.nextLine();

    	long number = Long.parseLong(input);
    	//System.out.println(number);

    	StackLinkedList<Integer> stackObj = new StackLinkedList<Integer>();
    	long binary[] = new long[56];
        int i = 0;
        while(number > 0){
            binary[i++] = number % 2;
            number = number/2;
        }
        for(int j = 0; j < i; j ++) {
        	stackObj.push((int)binary[j]);
        }

    	System.out.println(stackObj);
    	
	}
}
class StackLinkedList<E> {
    
	public Node headNode;
	@SuppressWarnings("unchecked")

	StackLinkedList() {
		this.headNode = new Node(null);
	}

	public boolean isEmpty() {
		if(headNode == null) {
			return true;
		} else {
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	public void push(E data) {
		Node temp = new Node(data);
		if(headNode == null) {
			headNode = temp;	
		} else {
			temp.setNext(headNode);
	        headNode = temp;
    	}
	}

	
	public void pop() {
		if(isEmpty()) {
			System.out.println("stack is isEmpty");
		} else {
			headNode = headNode.getNext();
		}
	}
	@SuppressWarnings("unchecked")
	public int top () {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return 0;
		} else {
			return (int)headNode.getData();
		}
	}
    
   	public String toString() {
        String output = "";
        if(headNode == null) {
            output = "List is Empty";
        } else {
            Node current = headNode;
            while (current.getNext() != null) {
                //System.out.println("*********");
                output += current.getData() ;
                current = current.getNext();
            }
        }
        return output;
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
