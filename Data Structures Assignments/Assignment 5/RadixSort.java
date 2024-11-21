

import java.util.Scanner;

public class RadixSort {
    
    public static void main(String[] args) {
        // create a scanner to read user input
        Scanner input = new Scanner(System.in);
        // create values array and size int so they have scope across all the if statements
        int[] inputs = new int[0];
        int size = 0;
        
        while(true){
           try{
                // print menu
                System.out.println("\n---------------MAIN MENU---------------\r\n" + //
                                "1 - Read array size\r\n" + //
                                "2 - Read array values\r\n" + //
                                "3 - Run Radix Sort and print outputs\r\n" + //
                                "4 - Exit program\r\n\n" + //
                                "Enter option number:");
                int option = Integer.parseInt(input.nextLine());
                // read array size
                if(option == 1){
                    System.out.println("Enter the array size");
                    size = Integer.parseInt(input.nextLine());
                    inputs = new int[size];
                }
                // read array values at each index
                else if(option == 2){
                    for(int i = 0; i < inputs.length; i++){
                        System.out.println("Enter the value at index " + i);
                        int value = Integer.parseInt(input.nextLine());
                        if(value >= 0){
                            inputs[i] = value;
                        }
                        else{
                            System.out.println("Enter a positive number");
                            i--;
                        }
                    }
                }
                // run radix sort and print outputs
                else if(option == 3){
                    // print the array values before the sort
                    System.out.print("Array values before sorting: ");
                    for(int n : inputs){
                        System.out.print(n + " ");
                    }
                    System.out.println();
                    
                    // create an array of queues where queues[0] = Q0, queues[1] = Q1,...., queues[9] = Q9
                    Queue<Integer>[] queues = new Queue[10];
                    for(int i = 0; i < 10; i++){
                        queues[i] = new Queue<Integer>();
                    }

                    // find the number of iterations required
                    int iterations = 0;
                    for(int i : inputs){
                        int numLength = countDigits(i);
                        if(numLength > iterations){
                            iterations = numLength;
                        }
                    }

                    // loop from 1 to the max iterations
                    for(int i = 1; i <= iterations; i++){
                        // loop through the inputs array
                        for(int n : inputs){
                            // take the last digit and put the number in the corresponding queue
                            int digit = extractDigit(n, i);
                            queues[digit].enqueue(n);
                        }

                        // loop through the queues array and empty each queue back into the input array
                        int index = 0;
                        for(int j = 0; j < 10; j++){
                            while(!queues[j].isEmpty()){
                                // put the number in the queue into the inputs array
                                inputs[index] = queues[j].front();
                                // remove the number from the queue
                                queues[j].dequeue();
                                index++;
                            }
                        }
                    }

                    System.out.print("Array values after sorting: ");
                    for(int n : inputs){
                        System.out.print(n + " ");
                    }
                    System.out.println();
                }
                // exit the loop
                else if(option == 4){
                    break;
                }
                // print if user does not input a valid integer option
                else{
                    System.out.println("Invalid input");
                }
            // handle any exceptions with user input
            }catch(Exception e){
                System.out.println("Invalid input");
            }
        }
        input.close();
    }

    // method CountDigits
    public static int countDigits(int n){
        // if the number is 0, it has one digit
        if(n == 0){
            return 1;
        }

        // until the number becomes 0, count the last digit and then remove it from the number
        int count = 0;
        while(n != 0){
            count++;
            n /= 10;
        }
        return count;
    }

    // method ExtractDigit from a number n and position pos (1 to length of n); pos is the position from the end of the number
    // so, pos = 1 gives the last digit of the number
    public static int extractDigit(int n, int pos){
        // remove the last digit of the number until you get to the input position
        for(int i = 1; i < pos; i++){
            n /= 10;
        }
        // return the digit at the input position
        return n % 10;
    }
}
