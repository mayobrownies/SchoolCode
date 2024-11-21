

import java.util.Scanner;

public class TestQueue {
    public static void main(String[] args) {
        // create a scanner to read user input
        Scanner input = new Scanner(System.in);
        // create an integer queue
        Queue<Integer> queue = new Queue<Integer>();
    
        while(true){
            try{
                // print menu
                System.out.println("\n--------MAIN MENU-------\r\n" + //
                                "1 - Enqueue element\r\n" + //
                                "2 - Dequeue element\r\n" + //
                                "3 - Get front element\r\n" + //
                                "4 - Get queue size\r\n" + //
                                "5 - Is empty queue?\r\n" + //
                                "6 - Print queue\r\n" + //
                                "7 - Exit program\r\n\n" + //
                                "Enter option number:");
                int option = Integer.parseInt(input.nextLine());
                // method enqueue(e)
                if(option == 1){
                    System.out.println("\nWhat value would you like to enqueue?");
                    int value = Integer.parseInt(input.nextLine());
                    System.out.print("Queue content before enqueue " + value + " is:   ");
                    queue.printQueue();
                    queue.enqueue(value);
                    System.out.println();
                    System.out.print("Queue content after enqueue " + value + " is:   ");
                    queue.printQueue();
                    System.out.println();
                }
                // method dequeue
                else if(option == 2){
                    if(queue.isEmpty()){
                        System.out.println("The queue is empty");
                    }
                    else{
                        System.out.print("Queue content before dequeue is:   ");
                        queue.printQueue();
                        System.out.println();
                        queue.dequeue();
                        System.out.print("Queue content after dequeue is:   ");
                        queue.printQueue();
                        System.out.println();
                    }
                }
                // method front()
                else if(option == 3){
                    if(queue.isEmpty()){
                        System.out.println("The queue is empty");
                    }
                    else{
                        System.out.println("The front element in the queue is " + queue.front());
                    }
                }
                // method size()
                else if(option == 4){
                    if(queue.isEmpty()){
                        System.out.println("The queue is empty");
                    }
                    else{
                        System.out.println("The queue size is: " + queue.size());
                    }
                }
                // method isEmpty()
                else if(option == 5){
                    if(queue.isEmpty()){
                        System.out.println("The queue is empty");
                    }
                    else{
                        System.out.println("The queue is not empty");
                    }
                }
                // method printStack()
                else if(option == 6){
                    if(queue.isEmpty()){
                        System.out.println("The queue is empty");
                    }
                    else{
                        System.out.print("The queue is: ");
                        queue.printQueue();
                        System.out.println();
                    }
                }
                // exit the loop
                else if(option == 7){
                    break;
                }
                // print if user does not input a valid integer option
                else{
                    System.out.println("Invalid input");
                }
            }
            // handle any errors with user input
            catch(Exception e){
                System.out.println("Invalid input");
            }
        }  
        input.close();
    }
}
