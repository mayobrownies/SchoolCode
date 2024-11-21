
import java.util.Scanner;

public class AverageGrades {
    public static void main(String[] args){
        // create scanner object to read user input
        Scanner input = new Scanner(System.in);
        // initialize a default class size and class grades with scope across all the if statements
        int classSize = 0;
        int[] classGrades = null;

        // programs loops with the menu until the user decides to exit the program
        while(true){
            try{
                // prompts the user with the menu and reads the option they pick
                System.out.println("\n--------MAIN MENU-------\n1. Read class size\n2. Read class grades\n3. Compute class average\n4. Exit program\n\nEnter option number:");
                int optionNum = Integer.parseInt(input.nextLine());

                // if the user picks 1, they are prompted for a class size; the class size input is read and a class grades array is create with that same size
                if(optionNum == 1){
                    System.out.println("\nEnter a class size:");
                    classSize = Integer.parseInt(input.nextLine());
                    classGrades = new int[classSize];
                }
                
                // if the user picks 2, they are prompted for class grades (entered separately); if the entered grade is between 0 and 100 inclusive, it is added to the array
                // otherwise, "Invalid input" is printed and the user can enter a new grade for the same index
                else if(optionNum == 2){
                    System.out.println("\nEnter class grades (0-100):");
                    for(int i = 0; i < classGrades.length; i++){
                        int grade = Integer.parseInt(input.nextLine());
                        if(grade >= 0 && grade <= 100){
                            classGrades[i] = grade;
                        }
                        else{
                            System.out.println("\nInvalid input\n");
                            i--;
                        }
                    }
                }

                // if the user picks 3, the program prints the class size and grades that the user entered, sends them to the findAverage method, and prints the result
                else if(optionNum == 3){
                    System.out.println("\nYou entered class size:  " + classSize);
                    System.out.print("You entered grades:      ");
                    for(int grade : classGrades){
                        System.out.print(grade + " ");
                    }
                    System.out.println("\nClass average:           " + String.format("%.2f", findAverage(classGrades, 0)));
                }

                // if the user picks 4, the program exits the while loop and terminates
                else if(optionNum == 4){
                    break;
                }

                // if the user picks anything other than 1, 2, 3, or 4 the program prints "Invalid input"
                else{
                    System.out.println("\nInvalid input");
                }
            // catches exceptions from converting user input to int, negative index, etc.
            }catch(Exception e){
                System.out.println("\nInvalid input");
            }
        }
    }

    public static double findAverage(int[] grades, int index){
        
        // on the first run of findAverage (when index is 0), set up the actual computation for finding the average where we divide the sum of all numbers 
        // by the number of elements; the recursive part of this method will be to find the sum of all the elements in the array
        if(index == 0){
            return (grades[index] + findAverage(grades, index+1)) / grades.length;
        }

        // if we are at the last element in the array, we return the element
        if(index == grades.length - 1){
            return grades[index];
        }
        
        // for all other indices, sum the value of grades at the index
        return grades[index] + findAverage(grades, index+1);
    }
}
