

public class MyStack<E> {

    public Node<E> ListName;

    public MyStack(){
        ListName = null;
    }

    public void push(E data){ // addLastNode
        // if the list has no items, add new node
        if(ListName == null){
            ListName = new Node<E>(data);
        }
        // adds a new node to the end of the list
        else{
            Node<E> temp = ListName;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node<E>(data);
        }
    }

    public void pop(){ // removeLastNode
        // if the list has one element, remove the first element
        if(ListName.next == null){
            // set a temp node to ListName
            Node<E> temp = ListName;
            // set ListName to the next node
            ListName = ListName.next;
            // cut the first node from the rest of the list
            // garbage collector collects the first node
            temp.next = null;      
        }
        else{
            // create a temp node and iterate through the list until temp is one before the last element
            Node<E> temp = ListName;
            while(temp.next.next != null){
                temp = temp.next;
            }
            // the pointer to the last element is set to null and the garbage collector takes the node
            temp.next = null;
        }
    }

    public E top(){
        // create a temp node and iterate through the list until you are at the last node
        Node<E> temp = ListName;
        while(temp.next != null){
            temp = temp.next;
        }
        // return the data in the last node, but do not remove it
        return temp.data;
    }

    public int size(){
        int listSize = 0;

        // iterate through the list
        // when temp != null, a node is present so increment listSize by 1 and increment temp
        Node<E> temp = ListName;
        while(temp != null){
            listSize++;
            temp = temp.next;
        }
        return listSize;
    }

    public boolean isEmpty(){
        // if the size of the list is zero, the list is empty
        return size() == 0;
    }

    public void printStack(){
        // create a temp node and iterate through the list
        Node<E> temp = ListName;
        while(temp != null){
            // when the node is not null, print out the node's data and increment temp
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    
    private class Node<E>
    {
      private E data;  //data field
      private Node<E> next; //link field
       
      public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}
