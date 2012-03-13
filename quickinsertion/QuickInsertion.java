public class QuickInsertion {
	
	// standard insertion sort - no external calls
	private static void iSort(int[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && (a[j] < a[j-1]); j--) {
				int t = a[j];
				a[j] = a[j-1];
				a[j-1] = t;
			}
		}
	}
	
	// standard qsort - no external calls
	private static void qSort(int[] a, int lo, int hi) {
		if (hi <= lo) return;
		int p = partition(a, lo, hi);
		qSort(a, lo, p-1);
		qSort(a, p+1, hi);
	}
	
	private static void qSort(int[] a) {
		qSort(a, 0, a.length-1);
	}
	
	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
	    int v = a[lo];
		while (true) { 
	    	while (a[++i] < v) if (i == hi) break;
			while (v < a[--j])
	        	if (j == lo) break;
				if (i >= j) break;

	    	int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}

		int t = a[lo];
		a[lo] = a[j];
		a[j] = t;

	    return j;
	}
	
	// cutoff sort method
	public static void sort(int[] a, int cutoff) {
		
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
		iSort(test);
		StdArrayIO.print(test);
		test = randomIntList(10);
		StdArrayIO.print(test);
		qSort(test);
		StdArrayIO.print(test);
	}
	
}