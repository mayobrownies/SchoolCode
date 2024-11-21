

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        // create a scanner to read user input
        Scanner input = new Scanner(System.in);
        // create a string stack
        MyStack<String> myStack = new MyStack<String>();
        // empty string to hold user input
        String s = "";

        while(true){
            try{
                // print menu
                System.out.println("\n-----------------MAIN MENU---------------\r\n" + //
                                    "1 - Read input string of words\r\n" + //
                                    "2 - Reverse string and display outputs\r\n" + //
                                    "3 - Exit program\r\n\n" + //
                                    "Enter option number:");
                int option = Integer.parseInt(input.nextLine());
                // reads input string
                if(option == 1){
                    System.out.println("Enter a string: ");
                    s = input.nextLine();
                }
                // reverses and prints the string
                else if(option == 2){
                    System.out.print("Entered string:   " + s);
                    System.out.println();

                    // create an empty string to hold the reversed string
                    String sReverse = "";
                    // split the input string into each word
                    String[] words = s.split(" ");
                    // push each word into the stack
                    for(String word : words){
                        myStack.push(word);
                    }
                    // add the top value to the reverse string and then pop it from the stack
                    while(!myStack.isEmpty()){
                        sReverse += myStack.top() + " ";
                        myStack.pop();
                    }

                    System.out.println("Reversed string:  " + sReverse);
                }
                // exits the loop
                else if(option == 3){
                    break;
                }
                // if the user does not enter a valid option
                else{
                    System.out.println("Invalid input");
                }
            }
            // catch any exceptions from user input
            catch(Exception e){
                System.out.println("Invalid input");
            }
        }
        input.close();
    }
}
