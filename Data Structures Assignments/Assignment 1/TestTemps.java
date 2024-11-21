
import java.util.Scanner;

public class TestTemps {
    public static void main(String[] args){
        try{
            // creates a scanner object to read user input
            Scanner input = new Scanner(System.in);

            // prompts the user for a temperature for each day of the week and stores the input
            System.out.println("Enter the temperature for Monday: ");
            int monday = Integer.parseInt(input.nextLine());
            System.out.println("Enter the temperature for Tuesday: ");
            int tuesday = Integer.parseInt(input.nextLine());
            System.out.println("Enter the temperature for Wednesday: ");
            int wednesday = Integer.parseInt(input.nextLine());
            System.out.println("Enter the temperature for Thursday: ");
            int thursday = Integer.parseInt(input.nextLine());
            System.out.println("Enter the temperature for Friday: ");
            int friday = Integer.parseInt(input.nextLine());
            System.out.println("Enter the temperature for Saturday: ");
            int saturday = Integer.parseInt(input.nextLine());
            System.out.println("Enter the temperature for Sunday: ");
            int sunday = Integer.parseInt(input.nextLine());

            // creates a DailyTemps object with an array of temperatures for each day of the week
            DailyTemps temps = new DailyTemps(new int[]{monday, tuesday, wednesday, thursday, friday, saturday, sunday});

            // testing DailyTemps's methods with user input
            System.out.println("\nTesting method printTemps():\n" + temps.printTemps());
            System.out.println("\nTesting method setTemp():\nEnter the index of the day (0-6) and its new temperature (in F)");
            int index = Integer.parseInt(input.nextLine());
            int newTemp = Integer.parseInt(input.nextLine());
            temps.setTemp(index, newTemp);
            System.out.println("\n" + temps.printTemps());
            System.out.println("\nTesting method freezing():\nThe number of freezing days is " + temps.freezing() + " days.");
            System.out.println("\nTesting method warmest():\nThe warmest day of the week is " + temps.warmest() + ".");

        // catches exceptions from converting user input to an integer and entering an index outside of [0, 6]
        }catch(Exception e){
            System.out.println("Invalid input");
        }
    }
}
