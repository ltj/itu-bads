/****************************************************************************
 *  Compilation:  javac WeightedQuickUnionUF.java
 *  Execution:  java WeightedQuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Weighted quick-union (without path compression).
 *
 ****************************************************************************/

public class WeightedQuickUnionUF {
    private int[] id;    // id[i] = parent of i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components
	private int countIso; // number of isolated nodes
    
	// Assigment: Instance variables
    private int total;
    private boolean giantComponentReached = false;
    private boolean nonIsolatedReached = false;

    // Create an empty union find data structure with N isolated sets.
    public WeightedQuickUnionUF(int N) {
        total = countIso = N; // assignment: save the total amount of elements
        count = N;
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public boolean isGiantComponent() {
        return giantComponentReached;
    }

    public boolean isNonIsolated() {
        return nonIsolatedReached;
    }

	// Assignment: Returns true if all elements are connected
	// the 'connected' stated is reached when the component counter
	// equals 1: One component contains all elements
    public boolean isConnected() {
        return count == 1;
    }

    // Return the number of disjoint sets.
    public int count() {
        return count;
    }

    // Return component identifier for component containing p
    public int find(int p) {
        while (p != id[p])
            p = id[id[p]]; // Assignment: added tree-depth reduction fix
        return p;
    }

   // Are objects p and q in the same set?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


   // Replace sets containing p and q with their union.
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // make smaller root point to larger one
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;

		// for(int x=0; x<sz.length; x++) {
		// 			StdOut.print(sz[x] + " ");
		// 		}
		// 		StdOut.println("count: " + count);

		// oy vey! We don't have to check for this condition before
		// the no. components is equal to or less that no. nodes
        if (!nonIsolatedReached && count <= (total / 2)) {
            if(isNonIsolation()) {
				nonIsolatedReached = true;
			}
        }

		// A giant component is present when the size of a newly unified
		// component is greater-than or equal to total/2.
        if (!giantComponentReached) {
            if (sz[i] >= total / 2) {
                giantComponentReached = true;
            }
        }
    }

	// Non-isolation is not present if a node is its own parent and has no children
	private boolean isNonIsolation() {
		int sum = 0;
		for(int i=0;i < sz.length;i++) {
			if(sz[i] == 1 && id[i] == i) return false;
		}
		return true;
	}


    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);

        // read in a sequence of pairs of integers (each in the range 0 to N-1),
        // calling find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println("# components: " + uf.count());
    }

}

