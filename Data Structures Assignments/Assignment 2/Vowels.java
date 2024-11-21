
import java.util.Scanner;

public class Vowels{
    public static void main(String[] args){
        // create scanner object to read user input
        Scanner input = new Scanner(System.in);
        // initialize a default inputString with a scope across all of the if statements
        String inputString = "";

        // programs loops with the menu until the user decides to exit the program
        while(true){
            try{
                // prompts user with the menu and reads the option they pick
                System.out.println("\n---------MAIN MENU---------\n1. Read input string\n2. Compute number of vowels\n3. Exit program\n\nEnter option number:");
                int optionNum = Integer.parseInt(input.nextLine());
                
                // if the user picks 1, the program prompts them for an input string
                if(optionNum == 1){
                    System.out.println("\nEnter input string: ");
                    inputString = input.nextLine();
                }
                // if the user picks 2, the program prints the user's input string and calls the countVowels method with the input string and prints the number of vowels
                else if(optionNum == 2){
                    System.out.println("\nYou entered string: " + inputString);
                    System.out.println("Number of vowels: " + countVowels(inputString));
                }
                // if the user picks 3, the program exits the while loop and terminates
                else if(optionNum == 3){
                    break;
                }
                // if the user picks anything other than 1, 2, or 3, the program outputs "Invalid input" and the menu appears again
                else{
                    System.out.println("\nInvalid input");
                }
            // catches exceptions from converting user input to int
            }catch(Exception e){
                System.out.println("\nInvalid input");
            }
        }
    }

    public static int countVowels(String word){
        int numVowels = 0;
        String vowels = "aeiouAEIOU";
        // if the word has no characters, return the number of already counted vowels
        if(word.length() == 0){
            return numVowels;
        }
        // if the first character of the word is in the vowels string, increment the number of vowels by 1
        if(vowels.contains(word.substring(0,1))){
            numVowels++;
        }
        // recursively call the method with word using all characters except the first since that was checked in the previous if statement
        // numVowels will also be recursively added with either a 0 or 1 depending on if the previous if statement is executed
        return numVowels + countVowels(word.substring(1));
    }
}