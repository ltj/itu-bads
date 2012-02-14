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
		if(n > 0 && n == q.length/4) resize(q.length/2);
		return item;
	}
	
	// return an iterator over the items in random order
	public Iterator<Item> iterator() {
		return new RandomIterator();
	}
	
	// RandomIterator class
	private class RandomIterator implements Iterator<Item> {
		private boolean[] seen = new boolean[n];
		private int visited = 0;
		
		public RandomIterator() {
			for(int i = 0; i < seen.length; i++) {
				seen[i] = false;
			}
		}
		
		public boolean hasNext() {
			return visited < n;
		}
		
		// return next elements. Most likely, elements get picked
		// more than once. Next works until every element has
		// been seen at least once
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			int i = StdRandom.uniform(n);
			if(!seen[i]) {
				seen[i] = true;
				visited++;
			}
			return q[i];
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
	
	// test client
	public static void main(String[] args) {
		RandomQueue<String> q = new RandomQueue<String>();
	    while (!StdIn.isEmpty()) {
	    	String item = StdIn.readString();
			if(item.equals("-") && !q.isEmpty()) StdOut.println(q.dequeue());
			else if(item.equals("size")) StdOut.println(q.size());
			else if(item.equals("sample")) StdOut.println(q.sample());
			else if(item.equals("iter")) {
				Iterator itr = q.iterator();
				while(itr.hasNext()) {
					StdOut.print(itr.next() + " ");
				}
			}
		 	else q.enqueue(item);
	    }
	    StdOut.println("(" + q.size() + " left on queue)");
	}
	

}