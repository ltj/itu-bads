import java.util.*;


public class MiningNobel 
{
    private static Double[] test = { 0.11, 0.22, 0.33, -0.66 };

	// Exhaustive search approach
    public static int exhaustiveCount(Double[] ds) {
		int n = ds.length;
		StdOut.println("n: " + n);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                for (int k = j+1; k < n; ++k) {
                    for (int l = k+1; l < n; ++l) {
                        if ((ds[i] + ds[j] + ds[k] + ds[l]) == 0) { count++; }
                    }
                }
            }
        }
        return count;
    }

	// ~ N^3 approach
	public static int fastCount(Double[] ds) {
		int n = ds.length;
		Arrays.sort(ds);
		int count = 0;
		for (int i = 0; i < n; i++) {
	    	for (int j = i+1; j < n; j++) {
				for (int k = j+1; k < n; k++) {
					int l = Arrays.binarySearch(ds, -(ds[i]+ds[j]+ds[k]));
	        		if (l > k) count++;
				}
			}
		}
		return count;
	}
   
	// main
    public static void main(String[] args) {
		
		In in = new In("constants.csv");
		ArrayList<Double> Arr = new ArrayList<Double>();
		String s = in.readLine();
		while(in.hasNextLine()){
			String[] split = s.split(",");
			Arr.add(Double.parseDouble(split[1]));	
			s = in.readLine();
		}
		
		Double[] A = Arr.toArray(new Double[0]);
		
		Stopwatch sw = new Stopwatch();
		StdOut.println("Exhaustive search count (n=352): " + exhaustiveCount(A));
		StdOut.println("Exhaustive search time: " + sw.elapsedTime());
		
		sw = new Stopwatch();
		StdOut.println("Exhaustive search count (n=4): " + exhaustiveCount(test));
		StdOut.println("Exhaustive search time: " + sw.elapsedTime());
		
		sw = new Stopwatch();
		StdOut.println("Fast search count: " + fastCount(A));
		StdOut.println("Fast search time: " + sw.elapsedTime());
	//	in.close();
    }
}
