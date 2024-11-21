

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // create a scanner to read user input
        Scanner input = new Scanner(System.in);

        // create a String BST and empty input string to hold the values later on
        BST<String> tree = new BST<String>();
        String inputStr = "";
        
        while(true){
            try{
                // print the menu
                System.out.println("\n-----------------MAIN MENU---------------\r\n" + //
                                        "1. Read input string\r\n" + //
                                        "2. Remove duplicates and display outputs\r\n" + //
                                        "3. Exit program\r\n\n" + //
                                        "Enter option number:");
                // read the user's option
                int option = Integer.parseInt(input.nextLine());
                System.out.println();
                // read input string
                if(option == 1){
                    // clear the previous inputs to allow for repeatability without restarting the program
                    inputStr = "";
                    tree.clear();
                    
                    // read the input string
                    System.out.println("Enter the input string: ");
                    inputStr = input.nextLine();
                }
                // process input string
                else if(option == 2){
                    // print the original text
                    System.out.println("Original Text: ");
                    System.out.println(inputStr);
                    System.out.println();

                    // split the text into each word and store the words in an array
                    String[] words = inputStr.split(" ");
                    // insert each word from the array into the BST; this will remove duplicates
                    for(String word : words){
                        tree.insert(word);
                    }
                    // print the data from the BST inorder
                    System.out.println("Processed Test: ");
                    tree.inorder();
                    System.out.println();

                }
                // exit program
                else if(option == 3){
                    break;
                }
                // print if the user does not enter a valid option
                else{
                    System.out.println("Invalid Input");
                }
            }
            // catch exceptions from user input
            catch(Exception e){
                System.out.println("Invalid Input");
            }
        }
        input.close();
    }
}
