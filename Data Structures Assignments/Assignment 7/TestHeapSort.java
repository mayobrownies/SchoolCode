

// Class Heap.java 
// Textbook - Listing 23.9, Page 878

public class TestHeapSort { 
   /** A test method */
   public static void main(String[] args) {
    
      // create 3 lists to test heap sort
      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53}; 

      Character[] list2 = {'w','f','A','X','T','Q','k','s','8','L','3','b','A','w','s','H','j','K','L'};

      String[] list3 = {"Data", "Structure", "Is", "Hard", "Computing", "Class", "To Pass"};

      // testing heap sort on list
      System.out.print("Original List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");
         
      HeapSort.heapSort(list);  //sort the list
      
      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");   

      
      // testing heap sort on list2
      System.out.print("\n\nOriginal List2:\t"); // print list2
      for (int i = 0; i < list2.length; i++)
         System.out.print(list2[i] + " ");
         
      HeapSort.heapSort(list2); // heap sort on list2
      
      System.out.print("\n\nSorted List2:\t");  // print sorted list2
      for (int i = 0; i < list2.length; i++)
         System.out.print(list2[i] + " ");  
         

      // testing heap sort on list3
      System.out.print("\n\nOriginal List3:\t");  //print list3
      for (int i = 0; i < list3.length; i++)
         System.out.print(list3[i] + " ");
         
      HeapSort.heapSort(list3);  // heap sort on list3
      
      System.out.print("\n\nSorted List3:\t");  //print sorted list3
      for (int i = 0; i < list3.length; i++)
         System.out.print(list3[i] + " ");  
   }
}
