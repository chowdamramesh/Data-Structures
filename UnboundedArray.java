import java.util.Scanner;
import java.util.*;

class UnboundArray<E> {
	int size;
    int capacity;
    E[] arrayObject;
    int beta;			
    int alpha;			
    int count;

    @SuppressWarnings("unchecked")
    UnboundArray() {
    	capacity = 1;
    	size = 0;
      	beta = 2;
      	alpha = 4;
      	arrayObject = (E[])new Object[capacity];
    }


    public void push(E element) {
		
		if (size == capacity) {
			reallocate(beta * size);
     
		} 
		{
		    arrayObject[size] = element;
		    size++;
		}
    }
    public void pop() {
      if (size == 0) {
        System.out.println("Array is Empty");
        reallocate(1);
      } else {
        arrayObject[size-1] = null;
        size--;
        if (alpha * size <= capacity  && size > 0) {
          reallocate(beta * size);
          
        }
      }
     
    }
    @SuppressWarnings("unchecked")
    public void reallocate(int nSize) {
      capacity = nSize;
      E[] temArr = (E[])new Object[capacity];
      for (int i = 0; i < size; i++) {
        temArr[i] = arrayObject[i];    
      }
      arrayObject = temArr;
    }

    public int capacity() {
      return capacity;
    }

    public int size() {
    	return size;
    }

    public void display()
	{
		if(size == 0){
			System.out.println("Array is empty");
		}
		int i;
		for(i=0;i<size-1;i++) {
			System.out.print(arrayObject[i] + " ");
		}
		System.out.println(arrayObject[size-1]);
	}

}


public class UnboundedArray{
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		String inputType;
		String operationToPerform;
		String read1;
		String read2;

		inputType = kb.next();

		switch(inputType) {
			case "I":
			  UnboundArray<Integer> intObj = new UnboundArray<Integer>();
				while(!(operationToPerform = kb.next()).equals("end")) {
				  switch(operationToPerform) {
					  case "push": 
						  	read1 =kb.next();
							intObj.push(Integer.parseInt(read1));
							break;
						case "pop": 
							intObj.pop();
							break;
						case "print": 
						  	intObj.display();
							break;
						case "size" :
							System.out.println(intObj.size());
							break;
						case "capacity" :	
							System.out.println(intObj.capacity());
							break;
						default: System.out.println("Invalid input");																	
					}
				}
			break;
			case "C":
				UnboundArray<Character> charObj = new UnboundArray<Character>();
				while(!((operationToPerform = kb.next()).equals("end"))) {
				  switch(operationToPerform) {
					  case "push": 
						  	read1 =kb.next();
							charObj.push(read1.charAt(0));
							break;
						case "pop": 
							charObj.pop();
							break;
						case "print": 
							charObj.display();
							break;
						case "size" :
							System.out.println(charObj.size());
							break;
						case "capacity" :	
							System.out.println(charObj.capacity());
							break;	
						default:
						  System.out.println("Invalid input");																	
					}
				}
			break;
			case "S" :
			  UnboundArray<String> strObj = new UnboundArray<String>();
				while(!(operationToPerform = kb.next()).equals("end")) {
				  switch(operationToPerform) {
					  case "push": 
							read1 =kb.next();
							strObj.push(read1);
							break;
						case "pop": 
							strObj.pop();
							break;
						case "print": 
							strObj.display();
							break;
						case "size" :
							System.out.println(strObj.size());
							break;
						case "capacity" :	
							System.out.println(strObj.capacity());
							break;
						default:
						  System.out.println("Invalid input");																	
					}
				}
			break;
			case "F":
			  UnboundArray<Float> floatObj = new UnboundArray<Float>();
				while(!(operationToPerform = kb.next()).equals("end")) {
				  switch(operationToPerform) {
						case "push": 
							read1 =kb.next();
							floatObj.push(Float.parseFloat(read1));
							break;
						case "pop": 
							floatObj.pop();
							break;														
						case "print": 
							floatObj.display();
							break;
						case "size" :
							System.out.println(floatObj.size());
							break;
						case "capacity" :	
							System.out.println(floatObj.capacity());
							break;
						default: 
						  System.out.println("Invalid input");																	
					}
				}
			break;
			default:
			  System.exit(0);
		}
	}
}
