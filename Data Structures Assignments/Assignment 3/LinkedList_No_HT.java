
/*
  This class define a linked list that stores integer values.
  The class does NOT use Head and Tail pointer as the textbook class deos.
*/

public class LinkedList_No_HT
{
   public Node ListName;

   //constructor method to create a list object with a specifc name. 
   public LinkedList_No_HT()
   {
      ListName = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (ListName == null) 
         ListName = new Node(data); //one node list
      else 
      {
         Node temp = ListName;
         while (temp.next != null) 
         {
            temp = temp.next;
         }
         
         temp.next = new Node(data); //link new node as last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node
   public void addFirstNode(int data)
   {
      // if the list has no items, add new node
      if(ListName == null){
         ListName = new Node(data);
      }
      // adds a new node to the front and sets ListName to the new node, so that ListName stays at the front of the list
      else{
         Node temp = ListName;
         Node newNode = new Node(data);
         newNode.next = temp;
         ListName = newNode;
      }
   }
   
      
   //method #2: add node at index
   public void addAtIndex(int index, int data)
   {
      //complete this method\
      // if the index is zero, use the addFirstNode method
      if(index == 0){
         addFirstNode(data);
      }
      else{
         Node newNode = new Node(data);
         Node temp = ListName;
         // increment temp until it is one before the target index
         for(int i = 0; i < index-1; i++){
            temp = temp.next;
         }
         // newNode points to the node at index
         newNode.next = temp.next;
         // temp points to newNode
         temp.next = newNode;
         // newNode is now at the index
      }
   }
      
      
   //method #3: remove first node
   public void removeFirstNode()
   {
      // set a temp node to ListName
      Node temp = ListName;
      // set ListName to the next node
      ListName = ListName.next;
      // cut the first node from the rest of the list
      // garbage collector collects the first node
      temp.next = null;
   }
      
      
   //method #4: remove last node
   public void removeLastNode()
   {
      //complete this method
      // if the list has one element, remove the first element
      if(ListName.next == null){
         removeFirstNode();
      }
      else{
         // create a temp node and iterate through the list until temp is one before the last element
         Node temp = ListName;
         while(temp.next.next != null){
            temp = temp.next;
         }
         // the pointer to the last element is set to null and the garbage collector takes the node
         temp.next = null;
      }
         
   }
    
    
   //method #5: remove node at index
   public void removeAtIndex(int index)
   {
      //complete this method
      // if the index is 0, remove the first node
      if(index == 0){
         removeFirstNode();
      }
      // if the index is the last node, use the removeLastNode() method
      else if(index == countNodes()-1){
         removeLastNode();
      }
      else{
         // create a temp node and iterate through the list until at index-1
         Node temp = ListName;
         for(int i = 0; i < index-1; i++){
            temp = temp.next;
         }
         // indexNode points to the node that is going to be removed
         Node indexNode = temp.next;
         // makes temp.next (the element at index-1) point to temp.next.next (the element at index+1)
         temp.next = temp.next.next;
         // cut the pointer from the node at the index so garbage collection collects it
         indexNode.next = null;
      }
   }
          
   //method #6: countNodes
   public int countNodes()
   {
      int listSize= 0;
      
      //complete this method to return the list size.
      // iterate through the list
      // when temp != null, a node is present so increment listSize by 1 and increment temp
      Node temp = ListName;
      while(temp != null){
         listSize++;
         temp = temp.next;
      }
        
      return listSize; 
   }

   
   //method #7: pritnInReverse (must be a Recursive method)
   public void printInReverseRecursive(Node L)
   {
      //complete this method as recursive method to ptint the list in revers order.
      // if L is null, stop the recursion
      if(L != null){
         // recurse through the entire list
         printInReverseRecursive(L.next);
         // now we are at the end of the list, so we go back down the stack trace
         // causing prints to occur in reverse order
         System.out.print(L.data + "   ");
      }
   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = ListName;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

