public class QuickInsertion {
	
	// standard insertion sort
	private static void iSort(int[] a) {
		iSort(a, 0, a.length);
	}
	
	// standard insertion sort of subarray - no external calls
	private static void iSort(int[] a, int lo, int hi) {
		for (int i = lo+1; i < hi+1; i++) {
			for (int j = i; j > lo && (a[j] < a[j-1]); j--) {
				int t = a[j];
				a[j] = a[j-1];
				a[j-1] = t;
			}
		}
	}
	
	// standard qsort
	private static void qSort(int[] a, int lo, int hi) {
		if(lo < hi) {
			int q = partition(a, lo, hi);
			qSort(a, lo, q-1);
			qSort(a, q+1, hi);
		}
	}
	
	// short qsort
	private static void qSort(int[] a) {
		qSort(a, 0, a.length-1);
	}
	
	// quicksort w cutoff
	private static void qSort(int[] a, int lo, int hi, int cutoff) {
		if(hi-lo <= cutoff) {
			iSort(a, lo, hi);
		}
		else if(lo < hi) {
			int q = partition(a, lo, hi);
			qSort(a, lo, q-1, cutoff);
			qSort(a, q+1, hi, cutoff);
		}
	}
	
	// qsort partition
	private static int partition(int[] a, int lo, int hi) {
		int pivot = a[hi]; // set pivot to last element
		int i = lo - 1; // index not yet known
		
		for (int j = lo; j < hi; j++) {
			if (a[j] <= pivot) {
				i++; // increase index if smaller part grows
				// Swap
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}

		// Swap pivot
		int t = a[i+1];
		a[i+1] = a[hi];
		a[hi] = t;

	    return i+1;
	}
	
	// sort method - quicksort w insertion sort cutoff
	public static void sort(int[] a, int cutoff) {
		qSort(a, 0, a.length-1, cutoff);
	}
	
	// return randomized int list of size s
	private static int[] randomIntList(int s) {
		int[] il = new int[s];
		// init
		for (int i = 0; i < il.length; i++) {
			il[i] = i;
		}
		// make random permutation
		for (int k = il.length - 1; k > 0; k--) {
			int i = StdRandom.uniform(k);
			int t = il[i];
			il[i] = il[k];
			il[k] = t;
		}
		return il;
	}
	
	public static void main(String[] args) {
		
		int[] test = randomIntList(10);
		StdArrayIO.print(test);
		iSort(test, 5, test.length-1);
		StdArrayIO.print(test);
		test = randomIntList(1000);
		StdArrayIO.print(test);
		sort(test, 10);
		StdArrayIO.print(test);
		
	}
	
}