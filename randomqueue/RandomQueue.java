/*********************************************************
 * Algoritmer og Datastrukturer, ITU, F2012
 * Author: Lars Toft Jacobsen (Algorythms)
 * RandomQueue class - not really a 'queue' in the FIFO
 * sense; more like a Bag-with-removal :)
 *
 * Based, to some extend, on ResizingArrayQueue.java [SW]
 *********************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<Item> implements Iterable<Item> {
	
	private Item[] q;		// Queue array
	private int n = 0;		// no. elements
	private int last = 0;	// last avialable index in array

	// construct empty RandomQueue
	public RandomQueue() {
		q = (Item[]) new Object[2];
	}
	
	// is the queue empty?
	public boolean isEmpty() {
		return (n == 0);
	}
	
	// return queue size (no. elements)
	public int size() {
		return (n);
	}
	
	// add an item
	public void enqueue(Item item) {
		// increase array size if necessary
		if(n == q.length) resize(2*q.length);
		// just add a new item at the last available index the array
		q[last++] = item;
		n++;
	}
	
	// return (but do not remove) a random item
	public Item sample() {
		return q[StdRandom.uniform(n)];
	}
	
	// remove and return a random item
	public Item dequeue() {
		if (isEmpty()) throw new RuntimeException("Queue underflow");
		// get random element and overwrite index with last element
		int i = StdRandom.uniform(n);
		Item item = q[i];
		q[i] = q[last-1];
		// Null last element value (delete) and update counters
		q[last-1] = null;
		n--;
		last--;
		// shrink array if necessary
		if (n > 0 && n == q.length/4) resize(q.length/2);
		return item;
	}
	
	// return an iterator over the items in random order
	public Iterator<Item> iterator() {
		return new RandomIterator();
	}
	
	// RandomIterator class
	private class RandomIterator implements Iterator<Item> {
		
		private Item[] copy = (Item[]) new Object[n];
		private int pos = 0;
				
		public RandomIterator() {
			// copy q
			for (int i = 0; i < last; i++) {
				copy[i] = q[i];
			}
			// make random permutation of copy
			for (int k = copy.length - 1; k > 0; k--) {
				int i = StdRandom.uniform(k);
				Item t = copy[i];
				copy[i] = copy[k];
				copy[k] = t;
			}
		}
		
		public boolean hasNext() {
			return pos < copy.length;
		}
		
		// return next elements. Most likely, elements get picked
		// more than once. Next works until every element has
		// been seen at least once
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			return copy[pos++];
		}
		
		public void remove() { 
			throw new UnsupportedOperationException();
		}
	}
	
	// resize the array
	private void resize(int s) {
		assert s >= n;
		Item temp[] = (Item[]) new Object[s];
		for(int i = 0; i < n; i++) {
			temp[i] = q[i];
		}
		q = temp;
		last = n;
	}
	
	// // test client
	// public static void main(String[] args) {
	// 	RandomQueue<String> q = new RandomQueue<String>();
	//     while (!StdIn.isEmpty()) {
	//     	String item = StdIn.readString();
	// 		if(item.equals("-") && !q.isEmpty()) StdOut.println(q.dequeue());
	// 		else if(item.equals("size")) StdOut.println(q.size());
	// 		else if(item.equals("sample")) StdOut.println(q.sample());
	// 		else if(item.equals("iter")) {
	// 			Iterator itr = q.iterator();
	// 			while(itr.hasNext()) {
	// 				StdOut.print(itr.next() + " ");
	// 			}
	// 		}
	// 	 	else q.enqueue(item);
	//     }
	//     StdOut.println("(" + q.size() + " left on queue)");
	// }
	
	public static void main(String args[]) {
    	// Build a queue containing the Integers 1,2,...,6:
	    RandomQueue<Integer> Q= new RandomQueue<Integer>();
	    for (int i = 1; i < 7; ++i) Q.enqueue(i); // autoboxing! cool!

	    // Print 30 die rolls to standard output
	    StdOut.print("Some die rolls: ");
	    for (int i = 1; i < 30; ++i) StdOut.print(Q.sample() +" ");
	    StdOut.println();

	    // Let's be more serious: do they really behave like die rolls?
	    int[] rolls= new int [10000];
	    for (int i = 0; i < 10000; ++i)
	      rolls[i] = Q.sample(); // autounboxing! Also cool!
	    StdOut.printf("Mean (should be around 3.5): %5.4f\n", StdStats.mean(rolls));
	    StdOut.printf("Standard deviation (should be around 1.7): %5.4f\n",
			  StdStats.stddev(rolls));

	    // Let's look at the iterator. First, we make a queue of colours:

	    RandomQueue<String> C= new RandomQueue<String>();
	    C.enqueue("red"); C.enqueue("blue"); C.enqueue("green"); C.enqueue("yellow"); 

	    Iterator I= C.iterator();
	    Iterator J= C.iterator();

	    StdOut.print("Two colours from first shuffle: ");
	    StdOut.print(I.next()+" ");
	    StdOut.print(I.next()+" ");

	    StdOut.print("\nEntire second shuffle: ");
	    while (J.hasNext()) StdOut.print(J.next()+" ");

	    StdOut.print("\nRemaining two colours from first shuffle: ");
	    StdOut.print(I.next()+" ");
	    StdOut.println(I.next());
	}

}