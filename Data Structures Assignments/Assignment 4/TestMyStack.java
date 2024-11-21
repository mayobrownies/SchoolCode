

import java.util.Scanner;

public class TestMyStack {
    public static void main(String[] args) {
        // create a scanner to read user input
        Scanner input = new Scanner(System.in);
        // create an integer stack
        MyStack<Integer> myStack = new MyStack<Integer>();

        while(true){
            try{
                // print menu
                System.out.println("\n--------MAIN MENU-------\r\n" + //
                                "1 - Push element\r\n" + //
                                "2 - Pop element\r\n" + //
                                "3 - Get top element\r\n" + //
                                "4 - Get stack size\r\n" + //
                                "5 - Is empty stack?\r\n" + //
                                "6 - Print stack\r\n" + //
                                "7 - Exit program\r\n\n" + //
                                "Enter option number:");
                int option = Integer.parseInt(input.nextLine());
                // method push(e)
                if(option == 1){
                    System.out.println("\nWhat value would you like to push?");
                    int value = Integer.parseInt(input.nextLine());
                    System.out.print("Stack content before pushing " + value + " is:   ");
                    myStack.printStack();
                    myStack.push(value);
                    System.out.println();
                    System.out.print("Stack content after pushing " + value + " is:   ");
                    myStack.printStack();
                    System.out.println();
                }
                // method pop()
                else if(option == 2){
                    if(myStack.isEmpty()){
                        System.out.println("The stack is empty");
                    }
                    else{
                        System.out.print("Stack content before pop is:   ");
                        myStack.printStack();
                        System.out.println();
                        myStack.pop();
                        System.out.print("Stack content after pop is:   ");
                        myStack.printStack();
                        System.out.println();
                    }
                }
                // method top()
                else if(option == 3){
                    if(myStack.isEmpty()){
                        System.out.println("The stack is empty");
                    }
                    else{
                        System.out.println("The top element in the stack is " + myStack.top());
                    }
                }
                // method size()
                else if(option == 4){
                    if(myStack.isEmpty()){
                        System.out.println("The stack is empty");
                    }
                    else{
                        System.out.println("The stack size is: " + myStack.size());
                    }
                }
                // method isEmpty()
                else if(option == 5){
                    if(myStack.isEmpty()){
                        System.out.println("The stack is empty");
                    }
                    else{
                        System.out.println("The stack is not empty");
                    }
                }
                // method printStack()
                else if(option == 6){
                    if(myStack.isEmpty()){
                        System.out.println("The stack is empty");
                    }
                    else{
                        System.out.print("The stack is: ");
                        myStack.printStack();
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
