import java.util.Queue;  
import java.util.LinkedList;

class Tree {  
  int data;  
  Tree left;  
  Tree right;  
    Tree(int data) {  
        this.data=data;  
    }
    public int getData() {
        return data;
    }
    public Tree getLeft() {
        return left;
    }
    public Tree getRight() {
        return right;
    }
}

class BinaryTree {  

    /*public void levelOrderTraversal(Tree start) {  
        Queue<Tree> theQueue=new LinkedList<Tree>();  
        theQueue.add(start);  
        while(!theQueue.isEmpty()) {  
            Tree current=theQueue.poll();  
            System.out.print(current.getData() + " ");
            if(current.left!=null) {
                theQueue.add(current.left);  
            }
            if(current.right!=null) { 
                theQueue.add(current.right);
            }      
        }
    }*/
    public int heightOfTree (Tree start) {
        int level = 1;
        Queue<Tree> q = new LinkedList<Tree>();
        //Queue q = new Queue();
        if(start == null) {
            return 0;
        }
        q.add(start);
        q.add(null);
        while(!q.isEmpty()) {
            start = q.remove();
            if(start == null) {
                if(!q.isEmpty()) 
                    q.add(null);
                level++;
            } else {
                if(start.getLeft() == null) {
                    q.add(start.getLeft());
                }
                if(start.getRight() == null) {
                    q.add(start.getRight());
                }
            }
        }
        return level;
    }
public Tree createBinaryTree() {  
    Tree root =new Tree(20);  
    Tree node1=new Tree(60);  
    Tree node2=new Tree(49);  
    Tree node3=new Tree(63);  
    Tree node4=new Tree(71);  
    Tree node5=new Tree(29);  
    Tree node6=new Tree(77);  
       
    root.left=node1;  
    root.right=node4;  
       
    node1.left=node2;  
    node1.right=node3;  
       
    node4.left=node5;  
    node4.right=node6;  
    return root;  
    }  
}
public class LevelOrderPrint {
    public static void main(String[] args) {  
        BinaryTree bi = new BinaryTree();  
       // Tree root = new Tree();
        Tree root = bi.createBinaryTree();  
       // bi = createBinaryTree();  
        // System.out.println("Level Order traversal ::");  
        // bi.levelOrderTraversal(root);
        int height = bi.heightOfTree(root);
        System.out.print("height is ::");
        System.out.println(height);
    }
}
 
