import java.util.Arrays;

public class MiningNobel 
{
    private static double[] test = { 0.11, 0.22, 0.33, -0.66 };

	// Exhaustive search approach
    public static int exhaustiveCount(double[] ds) {
		int n = ds.length;
        int count = 0, q = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    for (int l = k + 1; l < n; l++) {
                        if (ds[i] + ds[j] + ds[k] + ds[l] == 0) { count++; }
                    }
                }
            }
        }
        return count;
    }

	// ~ N^3 approach
	public static int fastCount(double[] ds) {
		int n = ds.length;
		Arrays.sort(ds);
		int count = 0;
		for (int i = 0; i < n; i++) {
	    	for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					double target = -(ds[i] + ds[j] + ds[k]);
					int l = Arrays.binarySearch(ds, target);
	        		if (l > k) count++;
				}
			}
		}
		return count;
	}
   
	// main
    public static void main(String[] args) {
		
        StdOut.println(exhaustiveCount(test));
		StdOut.println(fastCount(test));

		In in = new In("constants.csv");
		String[] stringsA = in.readAll().trim().split(" , |\\n");
		double[] A = new double[stringsA.length];
		for (int i = 0; i < A.length-1; i+=2) {
			A[i] = Double.parseDouble(stringsA[i+1]);
			StdOut.println(A[i]);
		}
		Stopwatch sw = new Stopwatch();
		StdOut.println("Exhaustive search count: " + exhaustiveCount(A));
		StdOut.println("Exhaustive search time: " + sw.elapsedTime());
		sw = new Stopwatch();
		StdOut.println("Fast search count: " + fastCount(A));
		StdOut.println("Fast search time: " + sw.elapsedTime());
		in.close();
    }
    
	
}
