import java.util.ArrayList;

public class Words {
	
	private static String[] words;
	
	// returns true if you can go from word 'from' to word 'to'
	public static boolean wordLinksTo(String from, String to) {
		for(int i = 1; i < from.length(); i++) {
			int at = to.indexOf(from.substring(i, i+1));
			if(at == -1) return false; // letter not found in (rest of) to
			to = to.substring(0,at) + to.substring(at+1,to.length());
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> data = new ArrayList<String>();
		
		In in = new In(args[0]);
		while(in.hasNextLine()) {
			String line = in.readLine();
			data.add(line);
		}
		
		words = data.toArray(new String[0]);
		
		Digraph dg = new Digraph(words.length);
		StdOut.println(dg);
	}
}
