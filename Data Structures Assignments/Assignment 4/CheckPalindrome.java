

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        // create a scanner to read user input
        Scanner input = new Scanner(System.in);
        // create a character stack
        MyStack<Character> myStack = new MyStack<Character>();
        // empty string to hold user input
        String s = "";

        while(true){
            try{
                // print menu
                System.out.println("\n-----------------MAIN MENU---------------\r\n" + //
                                    "1 - Read input string\r\n" + //
                                    "2 - Check palindrome and display output\r\n" + //
                                    "3 - Exit program\r\n\n" + //
                                    "Enter option number:");
                int option = Integer.parseInt(input.nextLine());
                // reads input string
                if(option == 1){
                    System.out.println("Enter a string: ");
                    s = input.nextLine();
                }
                // reverses the string and checks if it is a palindrome
                else if(option == 2){
                    System.out.print("Entered String:   " + s);
                    System.out.println();

                    // ensure capitalized letters do not affect the result
                    String sLower = s.toLowerCase();
                    // create an empty string to hold the reversed string
                    String sReverse = "";
                    // iterate over the input string and push each character into the stack
                    for(int i = 0; i < sLower.length(); i++){
                        char character = sLower.charAt(i);
                        myStack.push(character);
                    }
                    // add the top value to the reverse string and pop it from the stack
                    while(!myStack.isEmpty()){
                        sReverse += myStack.top();
                        myStack.pop();
                    }
                    
                    // check if the word is a palindrome by seeing if the lowercase version is equal to the reverse string
                    if(sLower.equals(sReverse)){
                        System.out.println("Judgement:        Palindrome");
                    }
                    else if(!sLower.equals(sReverse)){
                        System.out.println("Judgement:        Not Palindrome");
                    }

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
