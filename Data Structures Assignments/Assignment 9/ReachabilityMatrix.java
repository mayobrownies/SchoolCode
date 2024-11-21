
import java.util.Scanner;

public class ReachabilityMatrix{
    public static void main(String[] args) {
        // create scanner to read user input
        Scanner input = new Scanner(System.in);
        // matrix to hold inputs
        int[][] matrix = null;
        // user must pick option 1 first
        boolean option1 = false;

        while(true){
            try{
                // print menu
                System.out.println("\n------MAIN MENU------\r\n" + //
                                    "1. Enter graph data\r\n" + //
                                    "2. Print outputs\r\n" + //
                                    "3. Exit program\r\n\n" + //
                                    "Enter option number:");
                // read user input
                int option = Integer.parseInt(input.nextLine());
                // read graph data
                if(option == 1){
                    System.out.println("Enter the number of nodes (no more than 5): ");
                    // read matrix size
                    int numNodes = Integer.parseInt(input.nextLine());
                    if(numNodes <= 5 && numNodes > 0){
                        matrix = new int[numNodes][numNodes];
                        for(int i = 0; i < numNodes; i++){
                            for(int j = 0; j < numNodes; j++){
                                // read values for each matrix entry
                                System.out.print("Enter A1[" + i + ", " + j + "]: ");
                                int val = Integer.parseInt(input.nextLine());
                                matrix[i][j] = val;
                            }
                        }
                        // option1 has been exhausted, so option2 can now be used
                        option1 = true;
                    }
                    else{
                        System.out.println("The number of nodes must be no more than 5");
                    }
                }
                else if(option == 2 && option1){
                    System.out.println();
                    // print input matrix
                    System.out.println("Input Matrix: ");
                    printMatrix(matrix);
                    System.out.println();
                    // compute and print reachability matrix
                    System.out.println("Reachability Matrix: ");
                    int[][] reachabilityMatrix = computeReachabilityMatrix(matrix);
                    printMatrix(reachabilityMatrix);
                    System.out.println();
                    // compute and print in-degrees
                    System.out.println("In-degrees: ");
                    printInDegrees(matrix);
                    System.out.println();
                    // compute and print out-degress
                    System.out.println("Out-degrees: ");
                    printOutDegrees(matrix);
                    System.out.println();
                    // number of self-loops
                    numSelfLoops(matrix);
                    // cycles of length n
                    cyclesOfLengthN(matrix);
                    // paths of length 1
                    pathsOfLength1(matrix);
                    // paths of length n
                    pathsOfLengthN(matrix);
                    // paths of length 1 to n
                    pathsOfLength1ToN(matrix);
                    // cycles of length 1 to n
                    cyclesOfLength1ToN(matrix);

                }
                else if(option == 2 && !option1){
                    System.out.println("Must enter graph data with option 1 first");
                }
                // exit loop
                else if(option == 3){
                    break;
                }
                // print if the input is not 1, 2, or 3
                else{
                    System.out.println("Invalid input");
                }
            }
            // catach exceptions from user input
            catch(Exception e){
                System.out.println("Invalid input");
            }
        }
        input.close();
    }

    // multiply two matrices; used to compute the reachability matrix
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2){
        int n = matrix1.length;
        int[][] res = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return res;
    }

    // print a matrix
    public static void printMatrix(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // compute the reachability matrix
    public static int[][] computeReachabilityMatrix(int[][] matrix){
        int n = matrix.length;
        // curMatrix is A1, A2, A3, ...., An
        int[][] curMatrix = new int[n][n];
        // reachabilityMatrix is A1 + A2 + A3 + ... + An
        int[][] reachabilityMatrix = new int[n][n];

        // curMatrix and reachabilityMatrix are initially copies of matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                curMatrix[i][j] = matrix[i][j];
                reachabilityMatrix[i][j] = matrix[i][j];
            }
        }

        // since A1 is already made (matrix), we go from 1 to n
        for(int i = 1; i < n; i++){
            // nextMatrix = curMatrix * matrix (ex. A3 = A2 * A1)
            int[][] nextMatrix = multiplyMatrices(curMatrix, matrix);
            // add the values of nextMatrix to reachabilityMatrix (ex. R = A1 + A2)
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    reachabilityMatrix[j][k] += nextMatrix[j][k];
                }
            }
            // update the current matrix for the next iteration of the loop
            curMatrix = nextMatrix;
        }

        return reachabilityMatrix;
    }

    // compute and print the in-degree for each node
    public static void printInDegrees(int[][] matrix){
        int n = matrix.length;

        // loop for n nodes
        for(int i = 0; i < n; i++){
            int inDegree = 0;
            // loop through the rows of the corresponding node's column in the matrix and add any valid entries to inDegree
            for(int j = 0; j < n; j++){
                if(matrix[j][i] > 0){
                    inDegree += matrix[j][i];
                }
            }
            System.out.println("Node " + (i+1) + " in-degree is " + inDegree);
        }
    }

    // compute and print the out-degree for each node
    public static void printOutDegrees(int[][] matrix){
        int n = matrix.length;

        // loop for n nodes
        for(int i = 0; i < n; i++){
            int outDegree = 0;
            // loop through the columns of the corresponding node's row in the matrix and add any valid entries to outDegree
            for(int j = 0; j < n; j++){
                if(matrix[i][j] > 0){
                    outDegree += matrix[i][j];
                }
            }
            System.out.println("Node " + (i+1) + " out-degree is " + outDegree);
        }
    }

    // compute and print the number of self loops
    public static void numSelfLoops(int[][] matrix){
        int n = matrix.length;
        int numSelfLoops = 0;

        // loop through the main diagonal of the matrix and add any valid entries to numSelfLoops
        for(int i = 0; i < n; i++){
            if(matrix[i][i] > 0){
                numSelfLoops += matrix[i][i];
            }
        }
        System.out.println("Total number of self-loops: " + numSelfLoops);
    }

    // compute and print the number of cycles of length n edges (n is the number of nodes)
    public static void cyclesOfLengthN(int[][] matrix){
        // compute A1, ..., An just like in the reachability matrix method
        int n = matrix.length;
        int[][] curMatrix = new int[n][n];
        int cyclesOfLengthN = 0;

        // curMatrix is a copy of matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                curMatrix[i][j] = matrix[i][j];
            }
        }

        // multiply current matrix (A1, A2, ...) with matrix (A1) and continue to An, where n is the number of nodes
        for(int i = 1; i < n; i++){
            int[][] nextMatrix = multiplyMatrices(curMatrix, matrix);
            curMatrix = nextMatrix;
        }

        // loop through the main diagonal of matrix An (curMatrix) and add the valid entries, this finds the cycles of length n
        for(int i = 0; i < n; i++){
            if(curMatrix[i][i] > 0){
                cyclesOfLengthN += curMatrix[i][i];
            }
        }
        System.out.println("Total number of cycles of length " + n + " edges: " + cyclesOfLengthN);
    }

    // compute and print the number of paths of length 1
    public static void pathsOfLength1(int[][] matrix){
        int n = matrix.length;
        int pathsOfLength1 = 0;

        // use matrix A1 (matrix) and sum the number of valid entries to find the number of paths of length 1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] > 0){
                    pathsOfLength1 += matrix[i][j];
                }
            }
        }
        System.out.println("Total number of paths of length 1 edge: " + pathsOfLength1);
    }

    // compute and print the number of paths of length n
    public static void pathsOfLengthN(int[][] matrix){
        // compute A1, ..., An just like in the reachability matrix method
        int n = matrix.length;
        int[][] curMatrix = new int[n][n];
        int pathsOfLengthN = 0;

        // curMatrix is a copy of matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                curMatrix[i][j] = matrix[i][j];
            }
        }

        // multiply current matrix (A1, A2, ...) with matrix (A1) and continue to An, where n is the number of nodes
        for(int i = 1; i < n; i++){
            int[][] nextMatrix = multiplyMatrices(curMatrix, matrix);
            curMatrix = nextMatrix;
        }

        // sum the valid entries in matrix An (curMatrix), this finds the number of paths of length n
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(curMatrix[i][j] > 0){
                    pathsOfLengthN += curMatrix[i][j];
                }
            }
        }
        System.out.println("Total number of paths of length " + n + " edges: " + pathsOfLengthN);
    }

    // compute and print the number of paths of length 1 to n
    public static void pathsOfLength1ToN(int[][] matrix){
        int n = matrix.length;
        // use the sum of A1 + A2 + ... + An to find the number of paths of length 1 to N, this is the same as the reachability matrix
        int[][] reachabilityMatrix = computeReachabilityMatrix(matrix);
        int pathsOfLength1ToN = 0;

        // sum the valid entries in the reachability matrix, this finds the number of paths of length 1 to n
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(reachabilityMatrix[i][j] > 0){
                    pathsOfLength1ToN += reachabilityMatrix[i][j];
                }
            }
        }
        System.out.println("Total number of paths of length 1 to " + n + " edges: " + pathsOfLength1ToN);
    }

    // compute and print the number of cycles of length 1 to n
    public static void cyclesOfLength1ToN(int[][] matrix){
        int n = matrix.length;
        // use the sum of A1 + A2 + ... + An to find the number of cycles of length 1 to N, this is the same as the reachability matrix
        int[][] reachabilityMatrix = computeReachabilityMatrix(matrix);
        int cyclesOfLength1ToN = 0;

        // sum the valid entries in the main diagonal of the reachability matrix, this finds the number of cycles of length 1 to n
        for(int i = 0; i < n; i++){
            if(reachabilityMatrix[i][i] > 0){
                cyclesOfLength1ToN += reachabilityMatrix[i][i];
            }
        }
        System.out.println("Total number of cycles of length 1 to " + n + " edges: " + cyclesOfLength1ToN);
    }

}