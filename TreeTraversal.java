import java.io.*;
import java.util.*;
 
class Node {

    public int item;
    public Node leftChild;
    public Node rightChild;

    public int getItem() {
        return item;
    }
    public Node getLeftChild() {
        return leftChild;
    }
    public Node getRightChild() {
        return rightChild;
    }
    public void setItem(int item) {
        this.item = item;
    }
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}

class Tree {

    public Node root;
    public int count = 0;
    public int value = 0;
    
    public Tree() {
        root = null;
    }

    public Node returnRoot() {
        return root;
    }

    public void insertAndDisplay(int data) {
        insert(data);
        inOrder(root);
        display();
        rammi.clear();
    }

    public void insert(int data) {
        Node toInsert = new Node();
        toInsert.item = data;

        if(root == null) {
            root = toInsert;
        } else {
            Node current = root;
            Node p;
            do {
                p = current;
                if(data < current.item) {
                    current = current.leftChild;
                    if(current == null) {
                        p.leftChild = toInsert;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if(current == null) {
                        p.rightChild = toInsert;
                        return;
                    }
                }
            } while(true);
        }
    }

   
    public void searchData(int data) {
        Node temp = null;
        count = 0;
        temp = search(root,data);
        if(temp != null) {
            System.out.println("true"+","+count);
        } else {
            System.out.println("false"+","+value);
        }    
    }

    public Node search(Node root,int data) {
       // Node current = root;
        boolean flag = false;
        count++;
        if(root == null) {
            flag = true;
            return null;
        }
        if(root.getItem() == data) {
            return root;
        }
        else if(root.getItem() < data) {
            return search(root.getRightChild() , data);
        } else {
            value = root.getItem();
            return search(root.getLeftChild() , data);
        }
    }

    public void delete(int k) {
        if (root == null) {
            System.out.println("0");

        } else {
            try {
            root = delete(root, k);
            postOrder(root);
            display();
            rammi.clear();
            } catch(Exception e) {}
        }
    }
    public Node delete (Node root , int data) {
        Node temp,temp2;
        if (root.getItem() == data) {
            if (root.getLeftChild() == null && root.getRightChild() == null) {
                return null;
            }
            else if (root.getLeftChild() == null) {
                //System.out.println(root.getItem()+"left == null");
                temp = root.getRightChild();
                /*while(temp != null) {
                    temp = temp.getRightChild();
                }*/
                return temp;
            } else if (root.getRightChild() == null) {
                //System.out.println(root.getItem()+"right == null");
                temp = root.getLeftChild();
                temp2 = null;
                //System.out.println(temp.getItem()+"expected 2");
                while(temp.getRightChild() != null) {
                    temp2 = temp;
                    temp = temp.getRightChild();
                }
                root.setItem(temp.getItem());
                temp2.setRightChild(null);
                //System.out.println(temp2.getItem()+"expected 5");
                // temp2 = root.getRightChild();
                // System.out.println(temp2+"+++++++++++++++++++");
                return root;
            }
            else {
                temp2 = root.getRightChild();
                temp = root.getRightChild();
                while (temp.getLeftChild() != null){
                    temp = temp.getLeftChild();
                }
                temp.setLeftChild(root.getLeftChild());
                return temp2;
            }
        } else if (data < root.getItem()) {
            root.leftChild = delete(root.getLeftChild(),data);
        } else if(data > root.getItem()){
            root.rightChild = delete(root.getRightChild(),data);
        } else {
           postOrder(root);
           display();
        }
        return root;
    }    

    public void preOrder(Node root) {
        if(root != null) {   
            //System.out.print(root.item + " ");
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    public void inOrder(Node root) {
        if(root != null) {
            inOrder(root.leftChild);
            rammi.add(root.item);
            //System.out.print(root.item+" ");
            inOrder(root.rightChild);
        }

    }

    ArrayList<Integer> rammi = new ArrayList<Integer>();

    public void display() {
        for (int i =0; i < rammi.size()-1 ; i++ ) {
            System.out.print(rammi.get(i)+",");
        }
        System.out.print(rammi.get(rammi.size()-1));
    }
   

    public void postOrder(Node root) {
        if(root != null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            //System.out.print(root.item+" ");
            rammi.add(root.item);
        }
    }
}

public class TreeTraversal {
    public static void main(String[] args) throws IOException {

        Scanner kb = new Scanner(System.in);
        Tree theTree = new Tree();
        String input;
        input = kb.nextLine();

        String[] divide = input.split(",");

        for(int p = 0; p < divide.length; p++ ) {
            divide[p] = divide[p].trim();
        }
        for(int i = 0; i < divide.length;i++) {
            //System.out.println(divide[i]);
            while(!(divide[i]).equals("end")) {
                String[] temp = divide[i].split(" ");
                for(int j = 0; j < temp.length; j++) {
                    //System.out.println(temp[j]);
                    switch(temp[0]) {
                        case "I": 
                            theTree.insertAndDisplay(Integer.parseInt(temp[1]));
                            //theTree.inOrder(theTree.returnRoot());
                            System.out.println();
                            break;
                        case "R":
                            //System.out.println();
                            theTree.delete(Integer.parseInt(temp[1]));
                            //theTree.postOrder(theTree.returnRoot());
                            System.out.println();
                            break;
                            
                        case "S": 
                            theTree.searchData(Integer.parseInt(temp[1]));
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
    }   
}
