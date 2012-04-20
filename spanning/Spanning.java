import java.util.Hashtable;

public class Spanning {
	
	private static final int NOCITIES = 128;
	
	public static void main(String[] args) {
		
		In in = new In(args[0]);
		Hashtable cities = new Hashtable();
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(NOCITIES);
		
		// read all cities into arraylist
		for(int i = 0; i < NOCITIES; i++) {
			String line = in.readLine().trim();
			if(line.startsWith("\"")) cities.put(line.substring(1,line.length()-1), new Integer(i));
			else cities.put(line, new Integer(i));
		}
		
		// read rest of in-file (edges)
		while(in.hasNextLine()) {
			
			// read and parse lines
			String line = in.readLine().trim();
			String[] parts = line.split("--");
			String from = parts[0].startsWith("\"") ? parts[0].substring(1,parts[0].length()-1) : parts[0];
			parts = parts[1].split(" \\[");
			String to = parts[0].startsWith("\"") ? parts[0].substring(1,parts[0].length()-1) : parts[0];
			int dist = Integer.parseInt(parts[1].substring(0,parts[1].length()-1));
			
			// insert edge
			Integer v = (Integer)cities.get(from);
			Integer w = (Integer)cities.get(to);
			Edge e = new Edge(v.intValue(), w.intValue(), (double)dist);
			ewg.addEdge(e);
		}
		
		KruskalMST mst = new KruskalMST(ewg);
		StdOut.println("Weight: " + mst.weight());
		
	}
}