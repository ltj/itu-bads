public class GiantBook {

    private WeightedQuickUnionUF wqf;

    private static boolean reachedGiantStatus = false;
    private static boolean reachedNonIsolated = false;
    private static boolean reachedConnected = false;

	private static int[][] roundsStats;

	private static void doStats(int samples) {
		int i; 
		double nsum, gsum, csum, navg, gavg, cavg, ndiff, gdiff, cdiff; 
		nsum = gsum = csum = ndiff = gdiff = cdiff = 0.0;
		for (i=0; i < samples; i++) {
			nsum += roundsStats[i][0];
			gsum += roundsStats[i][1];
			csum += roundsStats[i][2];
		}
		navg = nsum / samples;
		gavg = gsum / samples;
		cavg = csum / samples;
		// find standard deviations
		for(i=0; i < samples; i++) {
			ndiff += Math.pow((roundsStats[i][0] - navg), 2);
			gdiff += Math.pow((roundsStats[i][1] - gavg), 2);
			cdiff += Math.pow((roundsStats[i][2] - cavg), 2);
		}
		StdOut.println("samples\t\tnon-isolation\t\tgiant\t\tconnected");
		StdOut.printf("%d\t\t%.2f (%.2f)\t\t%.2f (%.2f)\t\t%.2f (%.2f)\n", 
			samples, navg, Math.sqrt(ndiff/samples), 
			gavg, Math.sqrt(gdiff/samples), cavg, Math.sqrt(cdiff/samples));
	}
	
    public static void main(String[] args) {
        int count = StdIn.readInt();
		int samples = StdIn.readInt();
        int rounds = 0;
		roundsStats = new int[samples][3];
		
		StdOut.print("Crunching numbers");

		// If we have a connected state we have, by definition, also
		// the giant and non-isolation states and hence we're done
		// examining the set.
		for(int i = 0; i < samples; i++) {
			
			WeightedQuickUnionUF wqf = new WeightedQuickUnionUF(count);
        	
			while (!reachedConnected) {
	
				// count rounds. Round == (pseudo-)random union
				// needs to be incremented before checks
				rounds++;

	            wqf.union(
	                StdRandom.uniform(count),
	                StdRandom.uniform(count)
	            );

	            if (!reachedGiantStatus && wqf.isGiantComponent()) {
	                reachedGiantStatus = true;
					roundsStats[i][1] = rounds;
	                // StdOut.println("GIANTCOMPONENT ("+rounds+")");
	            }

	            if (!reachedNonIsolated && wqf.isNonIsolated()) {
	                reachedNonIsolated = true;
					roundsStats[i][0] = rounds;
	                //StdOut.println("NONISOLATED ("+rounds+")");
	            }

	            if (!reachedConnected && wqf.isConnected()) {
	                reachedConnected = true;
					roundsStats[i][2] = rounds;
	                // StdOut.println("CONNECTED ("+rounds+")");
	            }
	        }
			
			// reset
			StdOut.print('.');
			reachedNonIsolated = reachedGiantStatus = reachedConnected = false;
			rounds = 0;
		}

        StdOut.println("DONE.");
		doStats(samples);
    }

}