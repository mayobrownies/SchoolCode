

public class Queue<E> {
    
    public Node<E> ListName;

    public Queue(){
        ListName = null;
    }

    public void enqueue(E e){ // addLastNode
        // if the list has no items, add new node
        if(ListName == null){
            ListName = new Node<E>(e);
        }
        // adds a new node to the end of the list
        else{
            Node<E> temp = ListName;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node<E>(e);
        }
    }

    public void dequeue(){ // removeFirstNode
        // set a temp node to ListName
        Node<E> temp = ListName;
        // set ListName to the next Node
        ListName = ListName.next;
        // cut the first node from the rest of the list
        // garbage collector collects the first node
        temp.next = null;
    }

    public E front(){
        // return the data in the front of the queue (the first node)
        return ListName.data;
    }

    public int size(){
        int size = 0;
        Node<E> temp = ListName;
        // iterate through the list
        // when temp != null, a node is present so increment size by 1 and increment temp
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public boolean isEmpty(){
        // if the size of the list is 0, it is empty
        return size() == 0;
    }

    public void printQueue(){
        Node<E> temp = ListName;
        // iterate through the list with the temp node and print its data
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E item){
            data = item;
            next = null;
        }
    }
}
