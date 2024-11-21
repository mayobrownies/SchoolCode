

import java.util.Scanner;

public class myTest_No_HT
{
   public static void main (String[] args)
   {
      // create a scanner to read user input
      Scanner input = new Scanner(System.in);

      LinkedList_No_HT myList = new LinkedList_No_HT(); //create a list object

      // for (int i=1; i <= 5; i++) //add 5 nodes to the list
      // {
      //    myList.addLastNode(i*10);
      // } 
      
      while(true){
         System.out.println("\n\n---------MAIN MENU--------\r\n" + //
                     "1 - Add First Node\r\n" + //
                     "2 - Add Last Node\r\n" + //
                     "3 - Add At Index\r\n" + //
                     "4 - Remove First Node\r\n" + //
                     "5 - Remove Last Node\r\n" + //
                     "6 - Remove At Index\r\n" + //
                     "7 - Print List Size\r\n" + //
                     "8 - Print List Forward\r\n" + //
                     "9 - Print List In Reverse\r\n" + //
                     "10- Exit program\r\n\n" + //
                     "Enter option number:");
         try{
            int option = Integer.parseInt(input.nextLine());
            // method addFirstNode()
            if(option == 1){
               System.out.println("What value would you like to add?");
               int value = Integer.parseInt(input.nextLine());
               System.out.println("Adding value " + value + " as first node.");   
               System.out.print("List content before adding " + value + " is:   ");
               myList.printList();
               myList.addFirstNode(value);
               System.out.println();
               System.out.print("List content after adding " + value + " is:   ");
               myList.printList();
            }
            // method addLastNode()
            else if(option == 2){
               System.out.println("What value would you like to add?");
               int value = Integer.parseInt(input.nextLine());
               System.out.println("Adding value " + value + " as last node.");   
               System.out.print("List content before adding " + value + " is:   ");
               myList.printList();
               myList.addLastNode(value);
               System.out.println();
               System.out.print("List content after adding " + value + " is:   ");
               myList.printList();
            }
            // method addAtIndex()
            else if(option == 3){
                  System.out.println("What value would you like to add?");
                  int value = Integer.parseInt(input.nextLine());
                  System.out.println("At what index?");
                  int index = Integer.parseInt(input.nextLine());
                  // check to see if the index is within the bounds of the list
                  if(index >= 0 && index < myList.countNodes()){
                     System.out.println("Adding value " + value + " at index " + index + ".");   
                     System.out.print("List content before adding " + value + " is:   ");
                     myList.printList();
                     myList.addAtIndex(index, value);
                     System.out.println();
                     System.out.print("List content after adding " + value + " is:   ");
                     myList.printList();
                  }
                  else{
                     System.out.println("Invalid index, try again");
                  }
            }
            // method removeFirstNode
            else if(option == 4){
               // if the method uses data from the list, check if it's empty
               if(myList.ListName == null){
                  System.out.println("List is empty");
               }
               else{
                  System.out.println("Method removeFirstNode()");
                  System.out.print("List content before removing first node is:   ");
                  myList.printList();
                  myList.removeFirstNode();
                  System.out.println();
                  System.out.print("List content after removing first node is:   ");
                  myList.printList();
               }
            }
            // method removeLastNode()
            else if(option == 5){
               if(myList.ListName == null){
                  System.out.println("List is empty");
               }
               else{
                  System.out.println("Method removeLastNode()");
                  System.out.print("List content before removing last node is:   ");
                  myList.printList();
                  myList.removeLastNode();
                  System.out.println();
                  System.out.print("List content after removing last node is:   ");
                  myList.printList();
               }
            }
            // method removeAtIndex
            else if(option == 6){
               if(myList.ListName == null){
                  System.out.println("List is empty");
               }
               else{
                  System.out.println("What index would you like to remove at?");
                  int index = Integer.parseInt(input.nextLine());
                  // check if the input index is in the bounds of the list
                  if(index >= 0 && index < myList.countNodes()){
                     System.out.println("Method removeAtIndex("+index+")");
                     System.out.print("List content before removing at index " + index + " is:   ");
                     myList.printList();
                     myList.removeAtIndex(index);
                     System.out.println();
                     System.out.print("List content after removing at index " + index + " is:   ");
                     myList.printList();
                  }
                  else{
                     System.out.println("Invalid index, try again");
                  }
               }
            }
            // method countNodes()
            else if(option == 7){
               System.out.println("The list size is: " + myList.countNodes());
            }
            // method printList()
            else if(option == 8){
               if(myList.ListName == null){
                  System.out.println("List is empty");
               }
               else{
                  System.out.print("The list printed forward is:   ");
                  myList.printList();
                  System.out.println();
               }
            }
            // method printInReverseRecursive()
            else if(option == 9){
               if(myList.ListName == null){
                  System.out.println("List is empty");
               }
               else{
                  System.out.print("The list printed in reverse is:   ");
                  myList.printInReverseRecursive(myList.ListName);
                  System.out.println();
            
               }
            }
            // exits the loop
            else if(option == 10){
               break;
            }
         // catch any invalid inputs that the user may use
         }catch(Exception e){
            System.out.println("Invalid input");
         }
      }
      // close the scanner
      input.close();
   } 
}
    
