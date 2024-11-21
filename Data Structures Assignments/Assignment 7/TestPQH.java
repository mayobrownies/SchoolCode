

import java.util.Scanner;

public class TestPQH {
    public static void main(String[] args) {
        // create scanner to read user input
        Scanner input = new Scanner(System.in);

        // create a generic PQ_heap, queueType String, and hasType boolean which will update when the user inputs a valid type
        // and give access to the other options
        PQ_heap<?> queue = null; 
        String queueType = "";
        boolean hasType = false;

        while(true){
            try{
                // display menu
                System.out.println("\n----------------MAIN MENU---------------\r\n" + //
                                    "0. Enter Queue Type (integer or string)\r\n" + //
                                    "1. Enqueue Element\r\n" + //
                                    "2. Dequeue Element\r\n" + //
                                    "3. Check is_Full\r\n" + //
                                    "4. Check is_Empty\r\n" + //
                                    "5. Print PQueue Size\r\n" + //
                                    "6. Display Front Element\r\n" + //
                                    "7. Print PQueue Elements\r\n" + //
                                    "8. Exit program\r\n\n" + //
                                    "Enter option number:\r");

                int option = Integer.parseInt(input.nextLine());


                // exit loop
                if(option == 8){
                    break;
                }
                // enter queue type
                else if(option == 0){
                    System.out.println("Enter Queue Type (integer or string)");
                    String type = input.nextLine().toLowerCase();
                    // update the queue, queueType, and hasType accordingly based on the input
                    if(type.equals("string")){
                        queue = new PQ_heap<String>();
                        queueType = "string";
                        hasType = true;
                    }
                    else if(type.equals("integer")){
                        queue = new PQ_heap<Integer>();
                        queueType = "integer";
                        hasType = true;
                    }
                    // if the user inputs something other than integer or string, print invalid data type
                    else{
                        System.out.println("Invalid Data Type");
                    }
                }
                // run if no type has been selected
                else if(!hasType){
                    System.out.println("Enter a valid type for the priority queue");
                }
                // enqueue element
                else if(option == 1){
                    if(queue.is_full()){
                        System.out.println("The PQueue is full");
                    }
                    else{
                        System.out.println("Enter Data Element to Enqueue");
                        // check the type of the queue and then proceed with the correct enqueue code
                        // print the queue before and after the enqueue
                        if(queueType.equals("string")){
                            String str = input.nextLine();
                            System.out.println("Testing method Enqueue Data Element (Option 1)");
                            System.out.println("PQueue before inserting " + str + ":  ");
                            queue.print();
                            System.out.println();
                            ((PQ_heap<String>)queue).enqueue(str);
                            System.out.println("PQueue after inserting " + str + ":   ");
                            queue.print();
                            System.out.println();
                        }
                        else if(queueType.equals("integer")){
                            int i = Integer.parseInt(input.nextLine());
                            System.out.println("Testing method Enqueue Data Element (Option 1)");
                            System.out.println("Queue before inserting " + i + ":  ");
                            queue.print();
                            System.out.println();
                            ((PQ_heap<Integer>)queue).enqueue(i);
                            System.out.println("Queue after inserting " + i + ":   ");
                            queue.print();
                            System.out.println();
                        }
                    }
                }
                // dequeue element
                else if(option == 2){
                    if(queue.is_empty()){
                        System.out.println("The PQueue is empty");
                    }
                    else{
                        // check the type of the queue and proceed with the correct dequeue code
                        if(queueType.equals("string")){
                            // print the queue before and after the deletion
                            System.out.println("Testing method Dequeue Data Element (Option 2)");
                            System.out.println("PQueue before dequeue:  ");
                            queue.print();
                            System.out.println();
                            ((PQ_heap<String>)queue).dequeue();
                            System.out.println("PQueue after dequeue:   ");
                            queue.print();
                            System.out.println();
                            
                        }
                        else if(queueType.equals("integer")){
                            System.out.println("Testing method Dequeue Data Element (Option 2)");
                            System.out.println("PQueue before dequeue:  ");
                            queue.print();
                            System.out.println();
                            ((PQ_heap<Integer>)queue).dequeue();
                            System.out.println("PQueue after dequeue:   ");
                            queue.print();
                            System.out.println();
                            
                        }
                    }
                }
                // is full
                else if(option == 3){
                    System.out.println("Testing method is_full (option 3)");
                    if(queue.is_full()){
                        System.out.println("The PQueue is full");
                    }
                    else{
                        System.out.println("The PQueue is not full");
                    }
                }
                // is empty
                else if(option == 4){
                    System.out.println("Testing method is_empty (option 4)");
                    if(queue.is_empty()){
                        System.out.println("The PQueue is empty");
                    }
                    else{
                        System.out.println("The PQueue is not empty");
                    }
                }
                // get size
                else if(option == 5){
                    System.out.println("Testing method PQueue Size (option 5)");
                    System.out.println("PQueue size: " + queue.size());
                }
                // display front element
                else if(option == 6){
                    if(queue.is_empty()){
                        System.out.println("The PQueue is empty");
                    }
                    else{
                        System.out.println("Testing method front (option 6)");
                        System.out.println("The front element is " + queue.front());
                    }
                }
                // print elements
                else if(option == 7){
                    if(queue.is_empty()){
                        System.out.println("The PQueue is empty");
                    }
                    else{
                        System.out.println("Testing method print (option 7)");
                        queue.print();
                    }
                }
                // run if the user does not enter a valid option
                else{
                    System.out.println("Invalid input");
                }
                
            }
            // catch exceptions from user input
            catch(Exception e){
                System.out.println("Invalid input");
            }
        }
        input.close();
    }
}
