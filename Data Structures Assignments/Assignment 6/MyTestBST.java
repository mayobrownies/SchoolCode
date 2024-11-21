

import java.util.Scanner;

public class MyTestBST {
    public static void main(String[] args) {
        // create a scanner to read user input
        Scanner input = new Scanner(System.in);

        // create a generic tree, treeType String, and hasType boolean which will update when the user inputs a valid tree type
        // and give access to the other options
        BST<?> tree = null;
        String treeType = "";
        boolean hasType = false;

        while(true){
            try{
                // print menu
                System.out.println("\n----------------MAIN MENU---------------\r\n" + //
                                        "0. Enter Tree Data Type (integer or string)\r\n" + //
                                        "1. Insert Data Element\r\n" + //
                                        "2. Delete Data Element\r\n" + //
                                        "3. Search for Data Element\r\n" + //
                                        "4. Print Tree Size\r\n" + //
                                        "5. Path from Root to Data Element\r\n" + //
                                        "6. Check if Empty Tree\r\n" + //
                                        "7. Print Preorder Traversal\r\n" + //
                                        "8. Print Inorder Traversal\r\n" + //
                                        "9. Print Postorder Traversal\r\n" + //
                                        "10. Exit program\r\n\n" + //
                                        "Enter option number:");
                // read the user's option
                int option = Integer.parseInt(input.nextLine());
                System.out.println();
                // choose data type for tree
                if(option == 0){
                    System.out.println("Enter Tree Data Type (integer or string)");
                    String type = input.nextLine().toLowerCase();
                    // update the tree, treeType, and hasType accordingly based on the input
                    if(type.equals("string")){
                        tree = new BST<String>();
                        treeType = "string";
                        hasType = true;
                    }
                    else if(type.equals("integer")){
                        tree = new BST<Integer>();
                        treeType = "integer";
                        hasType = true;
                    }
                    // if the user inputs something other than integer or string, print invalid data type
                    else{
                        System.out.println("Invalid Data Type");
                    }
                }
                // all methods check if the type has been entered and will only run is hasType is true
                // insert method
                else if(option == 1 && hasType){
                    System.out.println("Enter Data Element to Insert");
                    // check the type of the tree and then proceed with the correct input code
                    // print the tree before and after the insert
                    if(treeType.equals("string")){
                        String str = input.nextLine();
                        System.out.println("Testing method Insert Data Element (Option 1)");
                        System.out.print("BST before inserting " + str + " (Inorder):  ");
                        tree.inorder();
                        System.out.println();
                        ((BST<String>)tree).insert(str);
                        System.out.print("BST after inserting " + str + " (Inorder):   ");
                        tree.inorder();
                        System.out.println();
                    }
                    else if(treeType.equals("integer")){
                        int i = Integer.parseInt(input.nextLine());
                        System.out.println("Testing method Insert Data Element (Option 1)");
                        System.out.print("BST before inserting " + i + " (Inorder):  ");
                        tree.inorder();
                        System.out.println();
                        ((BST<Integer>)tree).insert(i);
                        System.out.print("BST after inserting " + i + " (Inorder):   ");
                        tree.inorder();
                        System.out.println();
                    }
                }
                // delete method
                else if(option == 2 && hasType){
                    // check if the tree is empty
                    if(tree.isEmpty()){
                        System.out.println("The tree is empty");
                    }
                    else{
                        System.out.println("Enter Data Element to Delete");
                        // check the type of the tree and proceed with the correct delete code
                        if(treeType.equals("string")){
                            String str = input.nextLine();
                            // check if the element for deletion is in the tree
                            if(((BST<String>)tree).search(str)){
                                // print the tree before and after the deletion
                                System.out.println("Testing method Delete Data Element (Option 2)");
                                System.out.print("BST before deleting " + str + " (Inorder):  ");
                                tree.inorder();
                                System.out.println();
                                ((BST<String>)tree).delete(str);
                                System.out.print("BST after deleting " + str + " (Inorder):   ");
                                tree.inorder();
                                System.out.println();
                            }
                            // if the element is not in the tree, this prints
                            else{
                                System.out.println("Element not in tree");
                            }
                        }
                        else if(treeType.equals("integer")){
                            int i = Integer.parseInt(input.nextLine());
                            if(((BST<Integer>)tree).search(i)){
                                System.out.println("Testing method Delete Data Element (Option 2)");
                                System.out.print("BST before deleting " + i + " (Inorder):  ");
                                tree.inorder();
                                System.out.println();
                                ((BST<Integer>)tree).delete(i);
                                System.out.print("BST after deleting " + i + " (Inorder):   ");
                                tree.inorder();
                                System.out.println();
                            }
                            else{
                                System.out.println("Element not in tree");
                            }
                        }
                    }
                }
                // search method
                else if(option == 3 && hasType){
                    // check if the tree is empty
                    if(tree.isEmpty()){
                        System.out.println("The tree is empty");
                    }
                    else{
                        // check the type of the tree and proceed with the correct search code
                        System.out.println("Enter Data Element to Search");
                        if(treeType.equals("string")){
                            String str = input.nextLine();
                            System.out.println("Testing method Search for Data Element (Option 3)");
                            System.out.println("Is " + str + " in the tree? " + ((BST<String>)tree).search(str));
                        }
                        else if(treeType.equals("integer")){
                            int i = Integer.parseInt(input.nextLine());
                            System.out.println("Testing method Search for Data Element (Option 3)");
                            System.out.println("Is " + i + " in the tree? " + ((BST<Integer>)tree).search(i));
                        }
                    }
                }
                // tree size method
                else if(option == 4 && hasType){
                    System.out.println("Testing method Tree size (Option 4)");
                    System.out.println("Tree Size: " + tree.getSize());
                }
                // find path method
                else if(option == 5 && hasType){
                    // check if the tree is empty
                    if(tree.isEmpty()){
                        System.out.println("The tree is empty");
                    }
                    else{
                        System.out.println("Enter Data Element to Find Path");
                        // check the type of the tree and proceed with the correct path finding code
                        if(treeType.equals("string")){
                            String str = input.nextLine();
                            System.out.println("Testing method Path from Root to Data Element (Option 5)");
                            // check if the element to find is in the tree
                            if(((BST<String>)tree).search(str)){
                                System.out.print("Path from root to " + str + ": ");
                                // .path returns an arraylist of tree nodes which we iterate through and print the nodes' elements
                                for(BST.TreeNode<String> e : ((BST<String>)tree).path(str)){
                                    System.out.print(e.element + " ");
                                }
                                System.out.println();
                            }
                            // if the element is not in the tree, this prints
                            else{
                                System.out.println("Element not in tree");
                            }
                        }
                        else if(treeType.equals("integer")){
                            int i = Integer.parseInt(input.nextLine());
                            System.out.println("Testing method Path from Root to Data Element (Option 5)");
                            if(((BST<Integer>)tree).search(i)){
                                System.out.print("Path from root to " + i + ": ");
                                for(BST.TreeNode<Integer> e : ((BST<Integer>)tree).path(i)){
                                    System.out.print(e.element + " ");
                                }
                                System.out.println();
                            }
                            else{
                                System.out.println("Element not in tree");
                            }
                        }
                    }
                }
                // is empty method
                else if(option == 6 && hasType){
                    System.out.println("Testing method Check if Empty Tree (Option 6)");
                    System.out.println("Is empty tree? " + tree.isEmpty());
                }
                // preorder method
                else if(option == 7 && hasType){
                    // check if tree is empty
                    if(tree.isEmpty()){
                        System.out.println("The tree is empty");
                    }
                    // print a preorder traversal of the tree
                    else{
                        System.out.println("Testing method Preorder Traversal (Option 7)");
                        System.out.print("Preorder: ");
                        tree.preorder();
                        System.out.println();
                    }
                }
                // inorder method
                else if(option == 8 && hasType){
                    // check if tree is empty
                    if(tree.isEmpty()){
                        System.out.println("The tree is empty");
                    }
                    // print an inorder traversal of the tree
                    else{
                        System.out.println("Testing method Inorder Traversal (Option 8)");
                        System.out.print("Inorder: ");
                        tree.inorder();
                        System.out.println();
                    }
                }
                // postorder method
                else if(option == 9 && hasType){
                    // check if tree is empty
                    if(tree.isEmpty()){
                        System.out.println("The tree is empty");
                    }
                    // print a postorder traversal of the tree
                    else{
                        System.out.println("Testing method Postorder Traversal (Option 9)");
                        System.out.print("Postorder: ");
                        tree.postorder();
                        System.out.println();
                    }
                }
                // exit program
                else if(option == 10){
                    break;
                }
                // print if the user tries to input an option without entering a data type for the tree
                else if(!hasType){
                    System.out.println("Enter a data type for the tree");
                }
                // print if the user does not input a valid option
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
