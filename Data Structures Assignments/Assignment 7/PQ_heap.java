

// Generic code for class priority_queue_heap for Assignment 7 

public class PQ_heap<E extends Comparable<E>>
{	
	// generic heap
	Heap<E> heap;

	// Constructor method
    public PQ_heap() {
		// create heap
		heap = new Heap<>();
	}
	
	// Return true if priority queue is empty; otherwise return false
    public boolean is_empty() {
		// check if size is 0
		return heap.getSize() == 0;
	}
	
	// Return true if priority queue is full; otherwise return false
    public boolean is_full() {
		// getCapacity is new method in Heap.java
		return heap.getSize() == heap.getCapacity();
	}

	// Return (don't remove) the front element from the priority queue
	// Precondition: priority queue is not empty.
    public E front() {
		// front is implemented in Heap.java
		return heap.front();		
	}

	// return number of elements in the queue
    public int size() {
		return heap.getSize();
	}
   
	// Remove the largest value from this priority queue and return it.
	// Precondition: priority queue is not empty.
    public E dequeue() {
		return heap.remove();
	}

	// Inserts the 'value' into the priority queue.
	// Precondition: priority queue is not full
    public void enqueue(E value) {
		heap.add(value);
	}

	// printHeap is implemented in Heap.java
	public void print(){
		heap.printHeap();
	}
}
