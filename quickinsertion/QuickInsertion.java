public class QuickInsertion {
	
	// standard insertion sort
	private static void iSort(int[] a) {
		iSort(a, 0, a.length-1);
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
	
	// return randomized int list of size
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
	
	// ...randomIntList2 seems to be more compliant with
	// the assignment text
	private static int[] randomIntList2(int s, int bound) {
		int[] il = new int[s];
		for (int i = 0; i < il.length; i++) {
			il[i] = StdRandom.uniform(bound);
		}
		return il;
	}
	
// test client
	public static void main(String[] args) {
		
		int ntest = 100; // no. tests/cutoff value
		int cmin = 0; // cutoff min value
		int cmax = 20; // cutoff max value
		double[] runtime = new double[ntest];
		
		// for each size of array
		for (int n = 100; n <= 1000000; n *= 10) {
			StdOut.println("Testing for n="+n);
			// for each cutoff value 0..cmax
			for(int m = cmin; m < cmax+1; m++) {
				double total = 0.0;
				double dev = 0.0;
				double avg = 0.0;
				double stdDeviate = 0.0;
				// do ntest tests
				for(int t = 0; t < ntest; t++) {
					int[] a = randomIntList2(n, 10*n);
					// time and sort
					long start = System.currentTimeMillis();
					sort(a, m);
					runtime[t] = (System.currentTimeMillis() - start) / 1000.0;
				}
				// average runtime for all tests
				for (int k = 0; k < runtime.length; k++) {
					avg += runtime[k];
				}
				avg /= ntest;
				// std deviation
				for (int l = 0; l < runtime.length; l++) {
					dev += Math.pow(runtime[l]-avg, 2);
				}
				stdDeviate = Math.sqrt(dev/100);
				StdOut.println("m="+m+" avg="+avg+" std dev="+stdDeviate);
			}
			StdOut.println("n="+n+" done\n\n");
		}
		
	}
	
}