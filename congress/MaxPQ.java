import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ<Key extends Comparable> implements Iterable<Key>{
	
	private Key[] pq;
	private int N = 0;
	
	public MaxPQ(int max) {
		pq = (Key[]) new Comparable[max+1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	// insert new element at next available position
	// and swim up the tree
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	
	// return largest element
	public Key max() {
		return pq[1];
	}
	
	// shift the max key element
	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int k) {
		Key t = pq[i];
		pq[i] = pq[k];
		pq[k] = t;
	}
	
	// swim
	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	// sink
	private void sink(int k) {
		while (2*k <= N) {
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	public Iterator<Key> iterator() { 
		return new HeapIterator();
	}

	private class HeapIterator implements Iterator<Key> {
    	// create a new pq
      	private MaxPQ<Key> copy;

    	// add all elements to copy of heap
    	// takes linear time since already in heap order so no keys move
    	public HeapIterator() {
        	copy = new MaxPQ<Key>(pq.length-1);
        	for (int i = 1; i <= N; i++)
            	copy.insert(pq[i]);
    	}

		public boolean hasNext() { 
			return !copy.isEmpty();
		}
		
      	public void remove() {
			throw new UnsupportedOperationException();
		}

      	public Key next() {
			if (!hasNext()) throw new NoSuchElementException();
          	return copy.delMax();
      	}
  	}
	
}