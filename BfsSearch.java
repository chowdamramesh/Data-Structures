import java.util.*;
class Graph1 {
   int[][] adjMatrix;
   int rootNode =  0;
   int nNodes;
   boolean[] visited; 

   Graph1(int[][] matrix) {
      int i, j;
      nNodes = matrix.length;

      adjMatrix = new int[nNodes][nNodes];
      visited = new boolean[nNodes];

      for ( i=0; i < nNodes; i++) {
         for ( j=0; j < nNodes; j++) {
            adjMatrix[i][j] = matrix[i][j];
         }
      }   
   }


   public void bfs() {
     
      Queue<Integer> theQueue = new LinkedList<Integer>();

      theQueue.add(rootNode);
      visited[rootNode] = true;
      printNode(rootNode);

      while( !theQueue.isEmpty() ) {
         int n, child;

         n = (theQueue.peek()).intValue();
         //System.out.println(n + "/**//*//**/*/*/*////*");
         child = getUnvisited(n);

         if ( child != -1 ) {
            visited[child] = true;
            printNode(child);
            theQueue.add(child);
         } else {
            theQueue.remove();
         }
      }
      clearVisited();
   }

   int getUnvisited(int n) {
      int j;

      for ( j = 0; j < nNodes; j++ ) {
   	   if ( adjMatrix[n][j] > 0 ) {
   	      if ( ! visited[j] ) {
               return(j);
            }
         }
      }
      return(-1);
   }

   void clearVisited() {
      int i;

      for (i = 0; i < visited.length; i++) {
         visited[i] = false;
      }
   }

   void printNode(int n) {
      System.out.print((n+1) + " ");
   }
}

public class BfsSearch {
	public static void main(String[] args) {
		boolean[] check = new boolean[10];
		String input = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("size");
		int size = sc.nextInt();
		System.out.println("choice");

		int choice = sc.nextInt();
		sc.nextLine();
		Queue<Integer> theQueue = new LinkedList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		if(choice == 0) {
			for (int i = 0; i < 4; i++) {
				input = sc.nextLine();
				String[] divide = input.split("->");
				for (int j =0; j < divide.length; j++ ) {
					if(!check[Integer.parseInt(divide[j])]) {
						theQueue.add(Integer.parseInt(divide[j]));
						check[Integer.parseInt(divide[j])] = true;
					//System.out.println(divide[j]);
					}
				}
			}
			while( !theQueue.isEmpty() ) {
	         int n, child;
	         n = (theQueue.peek()).intValue();
	         System.out.print(n+ " ");
	         //result.add(n);
	         theQueue.remove();
	        }
		}
		if (choice == 1) {
			//Scanner sc = new Scanner(System.in);
			
	      	int[][] matrix = new int[8][8];
	      	for(int i = 0; i < 8;i ++) {
	         	for (int j = 0;j < 8;j++ ) {
	            	matrix[i][j] = sc.nextInt();
	         	}
	      	}
	      	Graph1 sample = new Graph1(matrix);
	      	sample.bfs();
		}		
	}
}

