
import java.util.Scanner;

public class TestRectangle{
    public static void main(String[] args){
        // creates a default rectangle object named myRectangle
        Rectangle myRectangle = new Rectangle();

        try{
            // creates a scanner object to read user input
            Scanner input = new Scanner(System.in);
            // prompts user, reads in user input, and converts it to a double
            System.out.println("Enter a width for your rectangle: ");
            double userWidth = Double.parseDouble(input.nextLine());
            System.out.println("Enter a height for your rectangle: ");
            double userHeight = Double.parseDouble(input.nextLine());

            // creates a rectangle object with height and width specified by the user
            Rectangle yourRectangle = new Rectangle(userWidth, userHeight);

            // testing all functions of class Rectangle
            System.out.println("Testing method getWidth() on object yourRectangle: " + yourRectangle.getWidth());
            System.out.println("Testing method getHeight() on object yourRectangle: " + yourRectangle.getHeight());
            System.out.println("Testing method getArea() on object yourRectangle: " + yourRectangle.getArea());
            System.out.println("Testing method getPerimeter() on object yourRectangle: " + yourRectangle.getPerimeter());
            System.out.println("Testing method printRectangle('yourRectangle') on object yourRectangle: " + yourRectangle.printRectangle("yourRectangle"));

            // prints out all details of myRectangle
            System.out.println("\nmyRectangle:\n------------");
            System.out.println("Width:      " + String.format("%.2f", myRectangle.getWidth()));
            System.out.println("Height:     " + String.format("%.2f", myRectangle.getHeight()));
            System.out.println("Area:       " + String.format("%.2f", myRectangle.getArea()));
            System.out.println("Perimeter:  " + String.format("%.2f", myRectangle.getPerimeter()));
            System.out.println("\n" + myRectangle.printRectangle("myRectangle"));

            // prints out all details of yourRectangle
            System.out.println("\n\nyourRectangle:\n------------");
            System.out.println("Width:      " + String.format("%.2f", yourRectangle.getWidth()));
            System.out.println("Height:     " + String.format("%.2f", yourRectangle.getHeight()));
            System.out.println("Area:       " + String.format("%.2f", yourRectangle.getArea()));
            System.out.println("Perimeter:  " + String.format("%.2f",yourRectangle.getPerimeter()));
            System.out.println("\n" + yourRectangle.printRectangle("yourRectangle"));
        // catches any exceptions from converting the user input to a double
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}